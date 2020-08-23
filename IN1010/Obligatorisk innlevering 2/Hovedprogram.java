import java.util.*;
import java.io.*;

public class Hovedprogram{
  public static void main(String[] args){

    PreparatA preparatA = new PreparatA("A", 100.0, 50.0, 25);
    PreparatB preparatB = new PreparatB("B", 200.0, 100.0, 50);
    PreparatC preparatC = new PreparatC("C", 250.0, 75.0);

    Spesialist SP = new Spesialist("Mehdi", 1);

    MilitaerResepter MR = new MilitaerResepter(preparatA, SP, 0, 1);
    PResepter PR = new PResepter(preparatB, SP, 1, 3);
    BlaaResepter BR = new BlaaResepter(preparatC, SP, 2, 2);

    System.out.println("");

    System.out.println("Legemidler og preparater: ");

    System.out.println("");

    // Returnerer 0.
    System.out.println(preparatA.hentId());
    // Returnerer A.
    System.out.println(preparatA.hentNavn());
    // Returnerer 100.0.
    System.out.println(preparatA.hentPris());
    // Returnerer 50.0.
    System.out.println(preparatA.hentVirkestoff());
    // Returnerer 25.
    System.out.println(preparatA.hentNarkotiskStyrke());
    // Bytter prisen til 150.0 og returnerer den.
    preparatA.settNyPris(150.0);
    System.out.println(preparatA.hentPris());

    System.out.println("");

    // Returnerer 1.
    System.out.println(preparatB.hentId());
    // Returnerer B.
    System.out.println(preparatB.hentNavn());
    // Returnerer 200.0.
    System.out.println(preparatB.hentPris());
    // Returnerer 100.0.
    System.out.println(preparatB.hentVirkestoff());
    // Returnerer 50.
    System.out.println(preparatB.hentVanedannendeStyrke());
    // Bytter prisen til 125.0 og returnerer den.
    preparatB.settNyPris(125.0);
    System.out.println(preparatB.hentPris());

    System.out.println("");

    // Returnerer 2.
    System.out.println(preparatC.hentId());
    // Returnerer C.
    System.out.println(preparatC.hentNavn());
    // Returnerer 250.0.
    System.out.println(preparatC.hentPris());
    // Returnerer 75.0.
    System.out.println(preparatC.hentVirkestoff());
    // Bytter prisen til 175.0 og returnerer den.
    preparatC.settNyPris(175.0);
    System.out.println(preparatC.hentPris());

    System.out.println("");

    System.out.println("Resepter: ");

    System.out.println("");

    // Returnerer 0.
    System.out.println(MR.hentId());
    // Returnerer A.
    System.out.println(MR.hentLegemiddel().hentNavn());
    // Returnerer Mehdi.
    System.out.println(MR.hentLege().hentNavn());
    // Returnerer 0.
    System.out.println(MR.hentPasientId());
    // Returnerer 1.
    System.out.println(MR.hentReit());
    // Returnerer true.
    System.out.println(MR.bruk());
    // Returnerer hvit.
    System.out.println(MR.farge());
    // Returnerer 0.0.
    System.out.println(MR.prisAaBetale());

    System.out.println("");

    // Returnerer 1.
    System.out.println(PR.hentId());
    // Returnerer B.
    System.out.println(PR.hentLegemiddel().hentNavn());
    // Returnerer Mehdi.
    System.out.println(PR.hentLege().hentNavn());
    // Returnerer 1.
    System.out.println(PR.hentPasientId());
    // Returnerer 3.
    System.out.println(PR.hentReit());
    // Returnerer true.
    System.out.println(PR.bruk());
    // Returnerer hvit.
    System.out.println(PR.farge());
    // Returnerer 84.0.
    System.out.println(PR.prisAaBetale());

    System.out.println("");

    // Returnerer 2.
    System.out.println(BR.hentId());
    // Returnerer C.
    System.out.println(BR.hentLegemiddel().hentNavn());
    // Returnerer Mehdi.
    System.out.println(BR.hentLege().hentNavn());
    // Returnerer 2.
    System.out.println(BR.hentPasientId());
    // Returnerer 2.
    System.out.println(BR.hentReit());
    // Returnerer true.
    System.out.println(BR.bruk());
    // Returnerer blaa.
    System.out.println(BR.farge());
    // Returnerer 62.5.
    System.out.println(BR.prisAaBetale());

    System.out.println("");

    System.out.println("Leger: ");

    System.out.println("");

    // Returnerer Mehdi.
    System.out.println(SP.hentNavn());
    // Returnerer 1.
    System.out.println(SP.hentKontrollID());

    // Returnerer egenskapene til reseptet uten feilmelding.
    try{
      System.out.println(SP.skrivResept(preparatB, 17, 34));
    } catch(UlovligUtskrift e){
      System.out.print("Ikke lov å skrive ut et narkotisk legemiddel.");
    }
    // Returnerer egenskapene til reseptet med feilmelding.
    try{
      System.out.println(SP.skrivResept(preparatA, 17, 34));
    } catch(UlovligUtskrift e){
      System.out.print("Ikke lov å skrive ut et narkotisk legemiddel.");
    }

    System.out.println("");

    System.out.println("Utskrift ved bruk av toString() metodene: ");

    System.out.println("");

    System.out.println(preparatA.toString());
    System.out.println(preparatB.toString());
    System.out.println(preparatC.toString());

    System.out.println("");

    System.out.println(MR.toString());
    System.out.println(PR.toString());
    System.out.println(BR.toString());

    System.out.println("");

    System.out.println(SP.toString());

    System.out.println("");

    try{
      File fil = new File("inndata.txt");
      Scanner innFil = new Scanner(fil);
      while (innFil.hasNextLine()){
        System.out.println(innFil.nextLine());
      }
    }
    catch(FileNotFoundException e){
      System.out.print("Kunne ikke åpne filen.");
    }

  }
}
