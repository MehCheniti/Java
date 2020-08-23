class TelleEksempel{

  public static void main(String[] args){
    // Thread t1 = new TelleTraad();
    // Thread t2 = new TelleTraad();
    Runnable telleJobb = new TelleJobb();
    Thread t1 = new Thread(telleJobb);
    Thread t2 = new Thread(telleJobb);
    t1.start();
    t2.start();

    try{
      Thread.sleep(4000);
    } catch (InterruptedException e) {}

    t1.interrupt();
    t2.interrupt();
  }

}

class TelleJobb implements Runnable{

  @Override public void run(){
    int teller = 0;

    while (!Thread.interrupted()){
      teller++;
    }
    System.out.println("Teller til " + teller + ".");
  }

}

class TelleTraad extends Thread{

  @Override public void run(){
    int teller = 0;

    while (!interrupted()){
      teller++;
    }
    System.out.println("Teller til " + teller + ".");
  }

}
