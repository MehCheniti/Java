import java.util.concurrent.CountDownLatch;

class OppgaveUtforelse implements Runnable{

OppgaveMonitor monitor = null;
CountDownLatch alleferdig;

  OppgaveUtforelse(OppgaveMonitor m, CountDownLatch a){
    monitor = m;
    alleferdig = a;
  }

  public void run(){
    try{
      while (!(monitor.erTom()) && !monitor.skalIkkeFyllesPaaMer()){
        String oppgave = monitor.hentOppgave();
        System.out.println("Starter paa " + oppgave + ".");
        Thread.sleep(200);
        System.out.println("Ble ferdig med " + oppgave + ".");
      }
    } catch (InterruptedException e){
      System.out.println("Vi ble avsluttet.");
    } finally{
      System.out.println("Ferdig med aa JOBBE, avslutter.");
      alleferdig.countDown();
    }
  }

}
