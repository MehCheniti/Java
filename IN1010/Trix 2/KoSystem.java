import java.util.*;

public class KoSystem{
  ArrayList<KoLapp> koLapper = new ArrayList<KoLapp>();
  int teller = 0;
    //Lager et nytt objekt av KoLapp, printer ut informasjon om den og legger den til i listen over koLapper.
    public void trekkKoLapp(){
      teller++;
      System.out.println(new KoLapp(teller).hentNummer());
      koLapper.add(new KoLapp(teller));
    }

    //Henter ut, printer ut informasjon og fjerner den forste kolappen i lista. Gir feilmelding dersom ingen kunder staar i ko.
    public void betjenKunde(){
      if (koLapper.isEmpty()){
        System.out.println("Ingen.");
      }
      else {
        KoLapp betjenes = koLapper.remove(0);
        System.out.println(betjenes.hentNummer());
      }
    }

    //Returnerer antall kunder som er i ko.
    public int antKunder(){
      return koLapper.size();
    }

    //Printer alle kunder i ko
    public void printKunderIKo(){
      for (int i = 0 ; i < koLapper.size() ; i++){
        System.out.print(i);
      }
    }

}
