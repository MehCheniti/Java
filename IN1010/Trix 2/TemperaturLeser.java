import java.util.Scanner;
import java.io.*;

public class TemperaturLeser{
  public static void main(String[] args) throws Exception{

    String[] minArray = new String[12];

    Scanner fil = new Scanner(new File("temperatur.txt"));
    int teller = 0;

    while (fil.hasNextLine()){
      minArray[teller] = fil.nextLine();
      teller++;
      }

    for (int i = 0 ; i < minArray.length ; i++){
      System.out.println(i);
    }

  }
}
