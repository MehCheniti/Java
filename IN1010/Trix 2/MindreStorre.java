import java.util.Scanner;

public class MindreStorre{
  public static void main(String[] args){
    double tall;
    Scanner innlest = new Scanner(System.in);
    System.out.println("Tall? ");
    tall = innlest.nextDouble();
    if (tall > 10){
      System.out.println("Tallet er storre enn 10.");
    }
    else{
      System.out.println("Taller er mindre enn 10.");
    }
    if (tall > 20){
      System.out.println("Tallet er storre enn 20.");
    }
    else{
      System.out.println("Taller er mindre enn 20.");
    }
  }
}
