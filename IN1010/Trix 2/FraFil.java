import java.util.Scanner;
import java.io.*;

public class FraFil{
  public static void main(String[] args) throws Exception{
    
    String filnavn = "tekst.txt";
    Scanner innlest = null;
    try{
      File fil = new File(filnavn);
      innlest = new Scanner(fil);
    } catch(FileNotFoundException e){
    }

  }
}
