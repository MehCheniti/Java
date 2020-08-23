import java.io.*;
import java.util.*;

class Operasjonsleder implements Runnable{

private KryptografMonitor monitor;
private int antallKanaler;
private ArrayList<Melding> meldinger = new ArrayList<Melding>();

  public Operasjonsleder(KryptografMonitor monitor, int antallKanaler){
    this.monitor = monitor;
    this.antallKanaler = antallKanaler;
  }

  public void run(){
    meldinger = monitor.hentMeldinger();
    Collections.sort(meldinger);

    PrintWriter pw = null;

    for (int i = 0; i < antallKanaler; i++){
      String str = "text" + i + ".txt";
      try{
        pw = new PrintWriter(str, "utf-8");
      } catch (FileNotFoundException e){
        System.out.println("Kan ikke finne filen.");
      } catch (UnsupportedEncodingException e){
        System.out.println("Kan ikke bruke utf-8.");
      }
      for (Melding melding : meldinger){
        if (melding.hentID() == i){
          pw.println(melding.hentInnhold());
          pw.println("");
        }
      }

      pw.close();
    }
  }

}
