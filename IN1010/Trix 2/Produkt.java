import java.util.Scanner;

public class Produkt{

public static void main(String[] args){

  String lest;
  int x;
  int y;

  Scanner innlest = new Scanner(System.in);

  System.out.print("x? ");
  lest = innlest.nextLine();
  x = Integer.parseInt(lest);

  System.out.print("y? ");
  lest = innlest.nextLine();
  y = Integer.parseInt(lest);

  System.out.println(x * y);

  if ((x - y) < 0){
    System.out.println("Negativ.");
  }
  else{
    System.out.println("Positiv.");
  }

  }
}
