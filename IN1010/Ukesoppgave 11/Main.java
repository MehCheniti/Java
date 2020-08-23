import java.util.*;

class Main{

  public static void main(String[] args){
    OppgaveMonitor monitor = new OppgaveMonitor();
    FyllPaa fylleOpp = new FyllPaa(monitor);
    OppgaveUtforelse utforelse = new OppgaveUtforelse(monitor);
    new Thread(fylleOpp, "Fyller opp.").start();

    for (int i = 0; i < 3; i++){
      Thread arbeider = new Thread(utforelse);
      arbeider.start();
    }

    Thread arbeider1 = new Thread(utforelse);
    Thread arbeider2 = new Thread(utforelse);
    arbeider1.start();
    arbeider2.start();
    Scanner in = new Scanner(System.in);

    while (!in.hasNext()){
      String input = in.next();
      if (in.next().equals("1")){
        arbeider1.interrupt();
      } else if (input.equals("2")){
        arbeider2.interrupt();
      } else if (input.equals("q")){
        break;
      }
    }

    arbeider1.interrupt();
    arbeider2.interrupt();
  }

}
