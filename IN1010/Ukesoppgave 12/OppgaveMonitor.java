import java.util.concurrent.locks.*;
import java.util.*;

class OppgaveMonitor{

ArrayList<String> arbeidsoppgaver = new ArrayList<String>();
Lock laas = new ReentrantLock();
Lock fyllePaaLaas = new ReentrantLock();
Condition ikkeTom = laas.newCondition();
boolean skalIkkeFyllesPaaMer;

  public String hentOppgave(){
    String oppgave = null;
    laas.lock();

    try{
      Thread.sleep(10);
      if (arbeidsoppgaver.size() == 0){
        System.out.println("Venter.");
        ikkeTom.await();
      }
      oppgave = arbeidsoppgaver.remove(0);
    } catch (InterruptedException e){
    } finally{
      laas.unlock();
    }

    return oppgave;
  }

  public boolean skalIkkeFyllesPaaMer(){
    fyllePaaLaas.lock();
    boolean b = skalIkkeFyllesPaaMer;
    fyllePaaLaas.unlock();
    return b;
  }

  public boolean settSkalIkkeFyllesPaaMer(){
    fyllePaaLaas.lock();
    skalIkkeFyllesPaaMer = true;
    fyllePaaLaas.unlock();
    return skalIkkeFyllesPaaMer;
  }

  public boolean erTom(){
    laas.lock();
    boolean bool = arbeidsoppgaver.size() == 0;
    ikkeTom.signal();
    laas.unlock();
    return bool;
  }

  public void fyllOpp(){
    laas.lock();
    arbeidsoppgaver.add("oppvask");
    ikkeTom.signal();
    arbeidsoppgaver.add("vasking av gulv");
    arbeidsoppgaver.add("rydding");
    laas.unlock();
    System.out.println("Ble fylt opp.");
  }

  public OppgaveMonitor(){
    arbeidsoppgaver.add("oppvask");
    arbeidsoppgaver.add("vasking av gulv");
    arbeidsoppgaver.add("rydding");
  }

}
