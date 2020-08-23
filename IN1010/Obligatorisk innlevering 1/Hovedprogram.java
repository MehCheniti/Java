import java.util.*;
import java.io.*;

public class Hovedprogram{

  public static void main(String[] args){
    String filnavn = "regneklynge.txt";
    Regneklynge abel = new Regneklynge(filnavn);

    System.out.println("Noder med minst 32 GB: " + abel.noderMedNokMinne(32) +
    ".");
    System.out.println("Noder med minst 64 GB: " + abel.noderMedNokMinne(64) +
    ".");
    System.out.println("Noder med minst 128 GB: " + abel.noderMedNokMinne(128) +
    ".");

    System.out.println("");

    System.out.println("Antal prosessorer: " + abel.antProsessorer() + ".");
    System.out.println("Antal racks: " + abel.antRacks() + ".");
  }

}
