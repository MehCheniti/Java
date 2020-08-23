import java.util.Scanner;

public class Differanse{

public static void main(String[] args){

  String lest;
  double x;
  double y;

  Scanner innlest = new Scanner(System.in);

  System.out.print("x?");
  lest = innlest.nextLine();
  x = Double.parseDouble(lest);

  System.out.print("y?");
  lest = innlest.nextLine();
  y = Double.parseDouble(lest);

  System.out.print(x - y);

  }
}
