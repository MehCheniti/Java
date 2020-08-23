class OppgaveUtforelse implements Runnable{

OppgaveMonitor monitor = null;

  OppgaveUtforelse(OppgaveMonitor m){
    monitor = m;
  }

  public void run(){
    try{
      while (true){
        String oppgave = monitor.hentOppgave();
        System.out.println("Starter paa " + oppgave + ".");
        Thread.sleep(200);
        System.out.println("Ble ferdig med " + oppgave + ".");
      }
    } catch (InterruptedException e){
      System.out.println("Vi ble avsluttet.");
    }
  }

}
