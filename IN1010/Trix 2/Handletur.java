import java.util.Scanner;

public class Handletur{
  public static void main(String[] args){
    Scanner innlest = new Scanner(System.in);

    System.out.println("Broed? ");
    String antall1 = innlest.nextLine();
    int x = Integer.parseInt(antall1);

    System.out.println("Melk? ");
    String antall2 = innlest.nextLine();
    int y = Integer.parseInt(antall2);

    System.out.println("Ost? ");
    String antall3 = innlest.nextLine();
    int z = Integer.parseInt(antall3);

    System.out.println("Youghurt? ");
    String antall4 = innlest.nextLine();
    int ae = Integer.parseInt(antall4);

    System.out.println("Du skal betale " + ((x*20) + (y*15) + (z*40) + (ae*12))
     + " kr.");
  }
}
