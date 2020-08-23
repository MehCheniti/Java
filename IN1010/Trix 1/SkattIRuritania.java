import java.util.Scanner;

public class SkattIRuritania{
  public static void main(String[] args){
    
    Scanner innlest = new Scanner(System.in);

    double inntekt;
    System.out.print("Inntekt? ");
    inntekt = Double.parseDouble(innlest.nextLine());

    if (inntekt < 10000){
      System.out.print("10%.");
    }
    else if (inntekt >= 10000){
      System.out.print("10% på de første 10000 og 30%.");
    }

  }
}
