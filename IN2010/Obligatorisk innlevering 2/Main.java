import java.io.*;
import java.util.*;

public class Main{

static int numberOfTasks;

  public static void main(String args[]){
    File fil = new File(args[0]);
    lesFraFil(fil);
  }

  private static void lesFraFil(File fil){
    LinkedList<Task> listOfTasks = new LinkedList<Task>();
    Scanner scanner = null;

    try{
      scanner = new Scanner(fil);
    } catch (FileNotFoundException e){
      System.out.println("Fant ikke filen.");
      return;
    }

    String innlest = scanner.nextLine();
    innlest = scanner.nextLine();

    while (scanner.hasNextLine()){
      LinkedList<Integer> dependencyEdges = new LinkedList<Integer>();
      innlest = scanner.nextLine();
      innlest = innlest.replaceAll("\\s+"," ");
      String[] info = innlest.split(" ");
      if (info.length > 3 && Integer.parseInt(info[4]) != 0){
        // Filler inn dependencyEdges med predecessors.
        for (int i = 4; i < info.length - 1; i++){
          dependencyEdges.add(Integer.parseInt(info[i]));
        }
      }
      int taskIdentity = Integer.parseInt(info[0]);
      String taskName = info[1];
      int timeEstimate = Integer.parseInt(info[2]);
      int manpowerRequirements = Integer.parseInt(info[3]);
      Task task = new Task(taskIdentity, timeEstimate, manpowerRequirements,
      taskName, dependencyEdges);
      numberOfTasks++;
      listOfTasks.add(task);
    }

    // Adder outedges.
    for (Task t : listOfTasks){
      for (Integer p : t.getPredecessors()){
        listOfTasks.get(p - 1).addOutEdge(t);
      }
    }

    // Adder inedges, og øker predecessors.
    for (Task t : listOfTasks){
      for (Task o : t.getOutEdges()){
        o.addInEdge(t);
        o.increaseCount();
      }
    }

    Project project = new Project(numberOfTasks, listOfTasks);

    if (project.isRealizable() == false){
      System.out.println("");
      System.out.println("Cycle found, the project is not realizable.");
      System.exit(0);
    } else{
      System.out.println("");
      System.out.println("Cycle not found, the project is realizable: ");
      System.out.println("");
    }

    project.earliestStart();
    project.latestStart();
    project.earliestFinish();
    project.latestFinish();
    project.slack();
    project.critical();

    project.printProject();
  }

  public static class Project{

  int numberOfTasks;
  LinkedList<Task> listOfTasks;

    public Project(int numberOfTasks, LinkedList<Task> listOfTasks){
      this.numberOfTasks = numberOfTasks;
      this.listOfTasks = listOfTasks;
    }

    public void earliestStart(){
      for (Task t : listOfTasks){
        if (t.getPredecessors2() == 0){
          t.newEarliestStart(0);
          for (Task t2 : t.getOutEdges()){
            t2.newEarliestStart(t.getTime());
          }
        }
      }

      for (Task t : listOfTasks){
        for (Task t2 : t.getOutEdges()){
          if (t2.getEarliestStart() < t.getEarliestStart() + t.getTime()){
            t2.newEarliestStart(t.getEarliestStart() + t.getTime());
          }
        }
      }
    }

    public void latestStart(){
      for (Task t : listOfTasks){
        if (t.getOutEdges().size() == 0){
          t.newLatestStart(t.getEarliestStart());
        }
        for (Task t2 : t.getOutEdges()){
          t2.newLatestStart(t.getTime());
        }
      }
    }

    public void earliestFinish(){
      for (Task t : listOfTasks){
        if (t.getPredecessors2() == 0){
          t.newEarliestFinish(t.getTime());
        } else{
          t.newEarliestFinish(t.getEarliestStart() + t.getTime());
        }
      }
    }

    public void latestFinish(){
      for (Task t : listOfTasks){
        t.newLatestFinish(t.getTime() + t.getLatestStart());
      }
    }

    public void slack(){
      for (Task t : listOfTasks){
        t.newSlack(t.getLatestStart() - t.getEarliestStart());
      }
    }

    public void critical(){
      for (Task t : listOfTasks){
        if (t.getSlack() == 0){
          t.critical();
        }
      }
    }

    public boolean isRealizable(){
      LinkedList<Task> whiteSet = new LinkedList<Task>();
      LinkedList<Task> graySet = new LinkedList<Task>();
      LinkedList<Task> blackSet = new LinkedList<Task>();

      for (Task t : listOfTasks){
        whiteSet.add(t);
      }

      while (whiteSet.size() > 0){
        Task dummyTask = whiteSet.iterator().next();
        if (DFS(whiteSet, graySet, blackSet, dummyTask) == true){
          return false;
        }
      }

      return true;
    }

    public boolean DFS(LinkedList<Task> w, LinkedList<Task> g,
    LinkedList<Task> b, Task t){
      w.remove(t);
      g.add(t);

      for (Task t2 : t.getOutEdges()){
        if (b.contains(t2)){
          continue;
        }
        if (g.contains(t2)){
          return true;
        }
        if (DFS(w, g, b, t2) == true){
          return true;
        }
      }

      g.remove(t);
      b.add(t);
      return false;
    }

    public void printProject(){
      int time = 0;
      int starting;
      int finished;
      Task[] startingList = new Task[numberOfTasks];
      Task[] finishedList = new Task[numberOfTasks];
      int currentStaff = 0;
      int counter = 0;

      while (counter != numberOfTasks){
        starting = 0;
        finished = 0;
        for (Task t : listOfTasks){
          if (t.getEarliestStart() == time){
            startingList[starting] = t;
            starting++;
          } else if (t.getEarliestFinish() == time){
            finishedList[finished] = t;
            finished++;
            counter++;
          }
        }
        if (startingList[0] != null || finishedList[0] != null){
          System.out.println("Time: " + time + ".");
          for (Task t : finishedList){
            if (t != null){
              currentStaff -= t.getStaff();
              System.out.println("Finished: " + t.getId() + ".");
            }
          }
          for (Task t : startingList){
            if (t != null){
              currentStaff += t.getStaff();
              System.out.println("Starting: " + t.getId() + ".");
            }
          }
          if (currentStaff != 0){
            System.out.println("Current staff: " + currentStaff + ".");
            System.out.println("");
            startingList = new Task[numberOfTasks];
            finishedList = new Task[numberOfTasks];
          }
        }
        time++;
      }

      System.out.println("");
      System.out.println("**** Shortest possible project execution is " +
      (time - 1) + ". ****");

      for (Task t : listOfTasks){
        System.out.println("");
        System.out.println("Identity number: " + t.getId() + ".");
        System.out.println("Name: " + t.getName() + ".");
        System.out.println("Time needed to finish the task: " + t.getTime() +
        ".");
        System.out.println("Manpower required to complete the task: " +
        t.getStaff() + ".");
        System.out.println("Earliest starting time: " + t.getEarliestStart() +
        ".");
        System.out.println("Slack: " + t.getSlack() + ".");
        System.out.println("List of tasks (dependencies) which depend on this task: "
        + t.getPredecessors() + ".");
      }
    }

  }

}
