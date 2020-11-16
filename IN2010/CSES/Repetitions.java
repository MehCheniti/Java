import java.util.Scanner;

public class Repetitions{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    // System.out.println("Please input the DNA sequence (in capital letters).");
    String str = scan.nextLine();
    int max = 0;
    int aCounter = 0;
    int cCounter = 0;
    int gCounter = 0;
    int tCounter = 0;

    if (str.matches("[ACGT]+")){
      for (int i = 0; i < str.length(); i++){
        if (i + 1 < str.length()){
          if (str.charAt(i) == 'A' && str.charAt(i) == str.charAt(i + 1)){
            aCounter++;
          } else if (str.charAt(i) == 'C' && str.charAt(i) == str.charAt(i + 1)){
            cCounter++;
          } else if (str.charAt(i) == 'G' && str.charAt(i) == str.charAt(i + 1)){
            gCounter++;
          } else if (str.charAt(i) == 'T' && str.charAt(i) == str.charAt(i + 1)){
            tCounter++;
          }
        }
      }
    } else{
      System.out.println("Error compiling DNA sequence.");
    }

    if (aCounter > cCounter && aCounter > gCounter && aCounter > tCounter){
      max = aCounter;
    } else if (cCounter > aCounter && cCounter > gCounter && cCounter >
    gCounter){
      max = cCounter;
    } else if (gCounter > aCounter && gCounter > cCounter && gCounter >
    tCounter){
      max = gCounter;
    } else if (tCounter > aCounter && tCounter > cCounter && tCounter >
    gCounter){
      max = tCounter;
    }

    System.out.println(max + 1);
  }

}
