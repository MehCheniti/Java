import java.util.Scanner;
import java.io.*;

public class Studentsystem{
  public static void main(String[] args) throws Exception{

    Scanner fil = new Scanner(new File("emnestudenter.txt"));
    while(fil.hasNextLine()){
      String linje = fil.nextLine();
      System.out.print(linje);
    }

  }
}
