import java.util.Scanner;

class HeiVerden{

  public static void main(String[] args){
    Scanner innlest = new Scanner(System.in);
    System.out.println("Hei! Hva heter du?");
    String lest = innlest.nextLine();
    System.out.println("Hei " + lest + "! Velkommen til IN1010.");
  }

}
