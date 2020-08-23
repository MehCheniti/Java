import java.util.*;
import java.io.*;

class Tekst{

  public static void main(String[] args){
    Scanner innlest = new Scanner(System.in);
    System.out.println("Hvilken fil skal leses?");
    String lest = innlest.nextLine();

    try{
      Scanner input = new Scanner(new File(lest));

      while (input.hasNextLine()){
        System.out.println(input.nextLine());
      }
    }

    catch(FileNotFoundException e){
      System.out.println(e.getMessage());
      System.exit(0);
    }
  }

}
