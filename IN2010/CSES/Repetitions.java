import java.util.Scanner;

public class Repetitions{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Please input the DNA sequence (in capital letters).");
    String str = scan.nextLine();
    int counter = 0;

    if (str.matches("[ACGT]+")){
      for (int i = 0; i < str.length(); i++){
        for (int j = i + 1; j < str.length(); j++){
          if (str.charAt(i) == str.charAt(j)){
            counter++;
          }
        }
      }
      // System.out.println(counter);
    } else{
      System.out.println("Error compiling DNA sequence.");
    }
  }

}
