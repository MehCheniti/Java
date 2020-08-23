class FyllPaa implements Runnable{

OppgaveMonitor monitor;

  public FyllPaa(OppgaveMonitor m){
    monitor = m;
  }

  public void run(){
    System.out.println("\n");

    try{
      Thread.sleep(7000);
      for (int i = 0; i < 1; i++){
        monitor.fyllOpp();
        Thread.sleep(70);
      }
    } catch (InterruptedException e){
      System.out.println("Hei.");
    }
  }

}
