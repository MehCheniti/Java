import java.util.*;

class Task{

int id, time, staff;
String name;
int earliestStart, latestStart;
int earliestFinish, latestFinish;
LinkedList<Task> outEdges;
LinkedList<Task> inEdges;
LinkedList<Integer> cntPredecessors;
int cntPredecessors2;
boolean isVisited = false;
int slack;
boolean isCritical = false;

  public Task(int id, int time, int staff, String name,
  LinkedList<Integer> cntPredecessors){
    this.id = id;
    this.time = time;
    this.staff = staff;
    this.name = name;
    this.cntPredecessors = cntPredecessors;
    outEdges = new LinkedList<Task>();
    inEdges = new LinkedList<Task>();
  }

  public int getId(){
    return id;
  }

  public int getTime(){
    return time;
  }

  public int getStaff(){
    return staff;
  }

  public String getName(){
    return name;
  }

  public int getEarliestStart(){
    return earliestStart;
  }

  public int getLatestStart(){
    return latestStart;
  }

  public int getEarliestFinish(){
    return earliestFinish;
  }

  public int getLatestFinish(){
    return latestFinish;
  }

  public LinkedList<Task> getOutEdges(){
    return outEdges;
  }

  public LinkedList<Task> getInEdges(){
    return inEdges;
  }

  public LinkedList<Integer> getPredecessors(){
    return cntPredecessors;
  }

  public void newEarliestStart(int s){
    earliestStart = s;
  }

  public void newLatestStart(int s){
    latestStart = s;
  }

  public void newEarliestFinish(int f){
    earliestFinish = f;
  }

  public void newLatestFinish(int f){
    latestFinish = f;
  }

  public int getPredecessors2(){
    return cntPredecessors2;
  }

  public void increaseCount(){
    cntPredecessors2++;
  }

  public void decreaseCount(){
    cntPredecessors2--;
  }

  public void visit(){
    isVisited = true;
  }

  public int getSlack(){
    return slack;
  }

  public void newSlack(int s){
    slack = s;
  }

  public void critical(){
    isCritical = true;
  }

  public void addOutEdge(Task o){
    if (outEdges.contains(o) == false){
      outEdges.add(o);
    }
  }

  public void addInEdge(Task i){
    if (inEdges.contains(i) == false){
      inEdges.add(i);
    }
  }

  public void removeOutEdge(Task o){
    outEdges.remove(o);
  }

  public void removeInEdge(Task i){
    inEdges.remove(i);
  }

}
