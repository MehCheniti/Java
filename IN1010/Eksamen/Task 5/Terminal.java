import java.util.Scanner;

public class Terminal implements UserInterface{

Scanner scanner;

  public Terminal(Scanner scanner){
    this.scanner = scanner;
  }

  @Override
  public void giveStatus(String status){
    System.out.println("\t" + status);
  }

  @Override
  public int askForCommand(String question, String[] options){
    while (true){
      System.out.println("[?]\t" + question);
      for (String option : options){
        System.out.println("> " + option);
      }
      System.out.print("\n>> ");
      String line = scanner.nextLine();
      System.out.println("");
      int index = 0;
      for (String option : options){
        if (option.contains(line)){
          return index;
        }
        index++;
      }
      System.out.println("[!]\tError, please try again.[!]\n");
    }
  }

}
