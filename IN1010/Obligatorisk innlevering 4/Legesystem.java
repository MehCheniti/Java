import java.util.*;
import java.io.*;

public class Legesystem{

  // Opprett lister som lagrer objektene i legesystemet.

  static Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
  static Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();
  static SortertLenkeliste<Lege> leger = new SortertLenkeliste<Lege>();
  static Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();

  public static void main(String[] args){
    File fil = new File("inndata.txt");
    lesFraFil(fil);
    kommandoLokke();
  }

  private static void lesFraFil(File fil){
    Scanner scanner = null;

    try{
      scanner = new Scanner(fil);
    } catch (FileNotFoundException e){
      System.out.println("Fant ikke filen, starter opp som et tomt " +
      "legesystem.");
      return;
    }

    String innlest = scanner.nextLine();

    while (scanner.hasNextLine()){
      String[] info = innlest.split(" ");

      // Legger til alle pasientene i filen.

      if (info[1].compareTo("Pasienter") == 0){
        while (scanner.hasNextLine()){
          innlest = scanner.nextLine();

          // Om vi er ferdig med å legge til pasienter, bryt whileløkken,
          // slik at vi fortsetter til koden for å legge til legemiddler.

          if (innlest.charAt(0) == '#'){
            break;
          }

          String[] navnOgfnr = innlest.split(", ");
          String navn = navnOgfnr[0];
          String fnr = navnOgfnr[1];
          pasienter.leggTil(new Pasient(navn, fnr));

        }
      }

            // Legger inn Legemidlene.

      else if (info[1].compareTo("Legemidler") == 0){
        while (scanner.hasNextLine()){
          innlest = scanner.nextLine();

          // Om vi er ferdig med å legge til legemidler, bryt whileløkken,
          // slik at vi fortsetter til koden for å legge til leger.

          if (innlest.charAt(0) == '#'){
            break;
          }

          String[] legemiddel = innlest.split(", ");
          String navn = legemiddel[0];
          String type = legemiddel[1];
          double pris = Double.parseDouble(legemiddel[2]);
          double virkestoff = Double.parseDouble(legemiddel[3]);
          int styrke;

          if (legemiddel[1].compareTo("a") == 0){
            styrke = Integer.parseInt(legemiddel[4]);
            legemidler.leggTil(new PreparatA(navn, pris, virkestoff, styrke));
          } else if (legemiddel[1].compareTo("b") == 0){
            styrke = Integer.parseInt(legemiddel[4]);
            legemidler.leggTil(new PreparatB(navn, pris, virkestoff, styrke));
          } else if (legemiddel[1].compareTo("c") == 0){
            legemidler.leggTil(new PreparatC(navn, pris, virkestoff));
          }
        }
      }

        // Legger inn leger.

        else if (info[1].compareTo("Leger") == 0){
          while (scanner.hasNextLine()){
            innlest = scanner.nextLine();

            // Om vi er ferdig med å legge til leger, bryt whileløkken, slik at
            // vi fortsetter til koden for å legge til resepter.

            if (innlest.charAt(0) == '#'){
              break;
            }

            info = innlest.split(", ");
            int kontrollid = Integer.parseInt(info[1]);

            if (kontrollid == 0){

            leger.leggTil(new Lege(info[0]));

            } else{

              leger.leggTil(new Spesialist(info[0], kontrollid));

            }
          }
        }

        // Legger inn resepter.

        else if (info[1].compareTo("Resepter") == 0){
          while (scanner.hasNextLine()){
            innlest = scanner.nextLine();
            info = innlest.split(", ");

            int legemiddelNummer = Integer.parseInt(info[0]);
            String legeNavn = info[1];
            int pasientID = Integer.parseInt(info[2]);
            int reit = Integer.parseInt(info[3]);

            Legemiddel dummyLegemiddel = null;
            for (Legemiddel legemiddel : legemidler){
              if (legemiddel.hentId() == legemiddelNummer){
                dummyLegemiddel = legemiddel;
              }
            }

            Lege dummyLege = null;
            for (Lege lege : leger){
              if (lege.hentNavn().compareTo(legeNavn) == 0){
                dummyLege = lege;
              }
            }

            Pasient dummyPasient = null;
            for (Pasient pasient : pasienter){
              if (pasient.hentId() == pasientID){
                dummyPasient = pasient;
              }
            }

            Resept blaaResept = new BlaaResepter(dummyLegemiddel, dummyLege,
            dummyPasient, reit);

            try{
              dummyLege.skrivResept(dummyLegemiddel, dummyPasient, reit);
            } catch (UlovligUtskrift e){
              System.out.println("Ikke lov å skrive ut et narkotisk " +
              "legemiddel.");
            }
            resepter.leggTil(blaaResept);
          }
        }
    }
  }

  public static void kommandoLokke(){
    while (true){
    System.out.println("Velkommen til menyen!");
    System.out.println("Vennligst tast inn 0 for en full oversikt over " +
    "legemidler, resepter, leger og pasienter.");
    System.out.println("Vennligst tast inn 1 for aa opprette og legge til " +
    "nye elementer i systemet.");
    System.out.println("Vennligst tast inn 2 for aa bruke en gitt resept " +
    "fra listen til en pasient.");
    System.out.println("Vennligst tast inn 3 for forskjellige former av " +
    "statistikk angaaende systemet.");
    System.out.println("Vennligst tast inn 4 for aa avslutte.");

    Scanner inp = new Scanner(System.in);
    String inp2 = inp.nextLine();
    Integer inp3 = Integer.parseInt(inp2);

    if (inp3 == 0){
      skrivUtOversikt();
    } else if (inp3 == 1){
      leggTilNyttElement();
    } else if (inp3 == 2){
      brukResept();
    } else if (inp3 == 3){
      skrivUtStatistikk();
    } else if (inp3 == 4){
      System.out.println("Takk for at du tok deg tid til aa bruke " +
      "legesystemet!");
      break;
    }
  }
  }

  public static void skrivUtOversikt(){
    System.out.println("Oversikt over legemidler: ");
    for (Legemiddel i : legemidler){
      System.out.println(i);
    }

    System.out.println("Oversikt over resepter: ");
    for (Resept i : resepter){
      System.out.println(i);
    }

    System.out.println("Oversikt over leger: ");
    for (Lege i : leger){
      System.out.println(i);
    }

    System.out.println("Oversikt over pasienter: ");
    for (Pasient i : pasienter){
      System.out.println(i);
    }
  }

  public static void leggTilNyttElement(){
    System.out.println("Hvilket element vil du legge til?");
    System.out.println("Vennligst tast inn 0 for et legemiddel.");
    System.out.println("Vennligst tast inn 1 for en resept.");
    System.out.println("Vennligst tast inn 2 for en lege.");
    System.out.println("Vennligst tast inn 3 for en pasient.");

    Scanner inp = new Scanner(System.in);
    String inp2 = inp.nextLine();

    if (inp2.equals("0")){
      System.out.println("Vennligst angi legemiddel argumentene i folgende " +
      "format: navn, type, pris, virkestoff [, styrke].");
      inp2 = inp.nextLine();
      String[] legemiddel = inp2.split(", ");
      String navn = legemiddel[0];
      String type = legemiddel[1];
      double pris = Double.parseDouble(legemiddel[2]);
      double virkestoff = Double.parseDouble(legemiddel[3]);
      int styrke;

      if (legemiddel[1].compareTo("a") == 0){
        styrke = Integer.parseInt(legemiddel[4]);
        legemidler.leggTil(new PreparatA(navn, pris, virkestoff, styrke));
      } else if (legemiddel[1].compareTo("b") == 0){
        styrke = Integer.parseInt(legemiddel[4]);
        legemidler.leggTil(new PreparatB(navn, pris, virkestoff, styrke));
      } else if (legemiddel[1].compareTo("c") == 0){
        legemidler.leggTil(new PreparatC(navn, pris, virkestoff));
      }
    } else if (inp2.equals("1")){
      System.out.println("Vennligst angi resept argumentene i folgende " +
      "format: legemiddelNummer, legeNavn, pasientID, reit.");
      inp2 = inp.nextLine();
      String[] info = inp2.split(", ");
      int legemiddelNummer = Integer.parseInt(info[0]);
      String legeNavn = info[1];
      int pasientID = Integer.parseInt(info[2]);
      int reit = Integer.parseInt(info[3]);

      Legemiddel dummyLegemiddel = null;
      for (Legemiddel legemiddel : legemidler){
        if (legemiddel.hentId() == legemiddelNummer){
          dummyLegemiddel = legemiddel;
        }
      }

      Lege dummyLege = null;
      for (Lege lege : leger){
        if (lege.hentNavn().compareTo(legeNavn) == 0){
          dummyLege = lege;
        }
      }

      Pasient dummyPasient = null;
      for (Pasient pasient : pasienter){
        if (pasient.hentId() == pasientID){
          dummyPasient = pasient;
        }
      }

      if (dummyLegemiddel == null || dummyLege == null || dummyPasient == null){
        return;
      }

      Resept blaaResept = new BlaaResepter(dummyLegemiddel, dummyLege,
      dummyPasient, reit);

      try{
        dummyLege.skrivResept(dummyLegemiddel, dummyPasient, reit);
      } catch (UlovligUtskrift e){
        System.out.println("Ikke lov å skrive ut et narkotisk " +
        "legemiddel.");
      }
      resepter.leggTil(blaaResept);
    } else if (inp2.equals("2")){
      System.out.println("Vennligst angi lege argumentene i folgende " +
      "format: navn, kontrollid / 0 hvis vanlig lege.");
      inp2 = inp.nextLine();
      String[] info = inp2.split(", ");
      int kontrollid = Integer.parseInt(info[1]);

      if (kontrollid == 0){
      leger.leggTil(new Lege(info[0]));
      } else{
        leger.leggTil(new Spesialist(info[0], kontrollid));
      }
    } else if (inp2.equals("3")){
      System.out.println("Vennligst angi pasient argumentene i folgende " +
      "format: navn, fnr.");
      inp2 = inp.nextLine();
      String[] navnOgfnr = inp2.split(", ");
      String navn = navnOgfnr[0];
      String fnr = navnOgfnr[1];
      pasienter.leggTil(new Pasient(navn, fnr));
    }
  }

  public static void brukResept(){
    Scanner inp = new Scanner(System.in);
    System.out.println("Hvilken pasient vil du se resepter for? Velg ID.");

    for (Pasient i : pasienter){
      System.out.println(i.hentId() + ": " + i.hentNavn() +
      " (fnr: " + i.hentFodselsnummer() + ").");
    }

    String inp2 = inp.nextLine();
    Integer inp3 = Integer.parseInt(inp2);
    Pasient valgtPasient = pasienter.hent(inp3);
    System.out.println("Valgt pasient: " + valgtPasient.hentNavn() +
    " (fnr: " + valgtPasient.hentFodselsnummer() + ").");
    System.out.println("Hvilken resept vil du bruke? Velg ID.");

    int teller = 0;
    Stabel<Resept> hentResept = valgtPasient.hentUtResept();

    for (Resept i : hentResept){
      System.out.println(teller + ": " + i.hentLegemiddel() + " (" +
      i.hentReit() + " reit).");
      teller++;
    }

    if (teller == 0){
      System.out.println(valgtPasient.hentNavn() +
      " har ingen utskrevne resepter.");
      return;
    }

    String inp4 = inp.nextLine();
    Integer inp5 = Integer.parseInt(inp4);
    Resept valgtResept = hentResept.hent(inp5);

    if (valgtResept.bruk() == true){
      System.out.println("Brukte resept paa " +
      valgtResept.hentLegemiddel().hentNavn() +
      ". Antall gjenvaerende reit: " + valgtResept.hentReit() + ".");
    } else{
      System.out.println("Kunne ikke bruke resept paa " +
      valgtResept.hentLegemiddel().hentNavn() + " (ingen gjenvaerende reit).");
    }
  }

  public static void skrivUtStatistikk(){
    Scanner inp = new Scanner(System.in);

    System.out.println("Hvilken type statistikk vil du se?");
    System.out.println("Vennligst tast inn 0 for antall resepter paa " +
    "vanedannende legemidler.");
    System.out.println("Vennligst tast inn 1 for antall resepter paa " +
    "narkotiske legemidler.");
    System.out.println("Vennligst tast inn 2 for statistikk om mulig " +
    "misbruk av narkotika.");

    String inp2 = inp.nextLine();

    if (inp2.equals("0")){
      int antallResepter = 0;
      for (Resept i : resepter){
        if (i.hentLegemiddel() instanceof PreparatB){
          antallResepter++;
        }
      }
      System.out.println("Antall vanedannende resepter: " + antallResepter +
      ".");

    } else if (inp2.equals("1")){
      int antallResepter = 0;
      for (Resept i : resepter){
        if (i.hentLegemiddel() instanceof PreparatA){
          antallResepter++;
        }
      }
      System.out.println("Antall narkotiske resepter: " + antallResepter + ".");

    } else if (inp2.equals("2")){
      System.out.println("Leger som har skrevet ut minst en narkotisk " +
      "resept: ");
      for (Lege i : leger){
        for (Resept i2 : i.utskrevendeResepter){
          if (i2.hentLegemiddel() instanceof PreparatA){
            System.out.println(i.hentNavn());
          }
        }
      }
      int antallResepter = 0;
      System.out.println("Pasienter med minst en narkotisk resept: ");
      for (Pasient i : pasienter){
        for (Resept i2 : i.hentUtResept()){
          if (i2.hentLegemiddel() instanceof PreparatA){
            antallResepter++;
          }
          System.out.println(i.hentNavn() + " har " + antallResepter +
          " resepter.");
        }
      }
    }
  }

}
