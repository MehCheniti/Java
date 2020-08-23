import java.util.Scanner;

public class KoProgram{
  public static void main(String[] args){

    KoSystem koSystem = new KoSystem();
       Scanner scanner = new Scanner(System.in);
       int valg = 0;

       while(valg != 4){
           printMeny();
           valg = Integer.parseInt(scanner.nextLine());

           if(valg == 1){
           koSystem.trekkKoLapp();
           } else if(valg == 2){
           koSystem.betjenKunde();
           } else if(valg == 3){
           koSystem.printKunderIKo();
           } else if(valg == 4){
           System.out.println("Programmet avsluttes.");
           } else {
           System.out.println("Error: tast 1,2,3 eller 4");
           }

  }
}

public static void printMeny(){
        String meny = "**MENY FOR BILLETTSYSTEM**\n";
        meny += "1 - Trekk ny kolapp\n";
        meny += "2 - Betjen kunde\n";
        meny += "3 - Print antall i ko\n";
        meny += "4 - Avslutt\n";

        System.out.println(meny);
    }
}
