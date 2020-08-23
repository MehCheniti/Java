import java.util.concurrent.CountDownLatch;

class Main{

  public static void main(String[] args){
    int antallTraader = 9;
    CountDownLatch alleferdig = new CountDownLatch(antallTraader);
    OppgaveMonitor monitor = new OppgaveMonitor();
    FyllPaa fylleOpp = new FyllPaa(monitor);
    OppgaveUtforelse utforelse = new OppgaveUtforelse(monitor, alleferdig);

    new Thread(fylleOpp, "Fyller opp.").start();

    for(int i = 0; i < antallTraader; i++){
      Thread arbeider = new Thread(utforelse, "Arbeider: "+ i);
      arbeider.start();
    }

    System.out.println("Nå er alle ferdig.");
  }

}
