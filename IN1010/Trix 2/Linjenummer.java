import java.util.*;
import java.io.*;

public class Linjenummer{
  public static void main(String[] args) throws Exception{

    Scanner fil = new Scanner(new File("tekst.txt"));
    String linje = "";
    for(int i = 0; fil.hasNextLine(); i++){
      linje = fil.nextLine();
      System.out.print("/*" + i + "*/" + linje);
    }

  }
}
