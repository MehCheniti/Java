import java.util.ArrayList;
import java.util.concurrent.locks.*;
import java.util.concurrent.CountDownLatch;

public class KryptografMonitor{

private ArrayList<Melding> meldinger = new ArrayList<Melding>();
private Lock laas;
private Condition ikkeTom;
private boolean slutt = false;

  public KryptografMonitor(){
    this.laas = new ReentrantLock();
    this.ikkeTom = laas.newCondition();
  }

  public void leggTilMelding(Melding melding) throws InterruptedException{
    laas.lock();

    try{
      meldinger.add(melding);
      ikkeTom.signalAll();
    } finally{
      laas.unlock();
    }
  }

  public Melding hentMelding() throws InterruptedException{
    laas.lock();

    try{
      if (meldinger.isEmpty() && slutt){
        return null;
      }
      while (meldinger.isEmpty() && !slutt){
        ikkeTom.await();
      }
      return meldinger.remove(0);
    } finally{
      laas.unlock();
    }
  }

  public ArrayList<Melding> hentMeldinger(){
    return meldinger;
  }

  public boolean hentSlutt(){
    return this.slutt;
  }

  public void slutt(){
    this.slutt = true;
  }

}
