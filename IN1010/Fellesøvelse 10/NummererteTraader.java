import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NummererteTraader implements Runnable{

private static int antallTraader = 0;
private Lock laas = new ReentrantLock();

  public static void main(String[] args){
    Runnable startStopp = new NummererteTraader();
    Thread[] traader = new Thread[200];

    for (int i = 0; i < traader.length; i++){
      traader[i] = new Thread(startStopp);
      traader[i].start();
    }

    try{
      for (int i = 0; i < traader.length; i++){
        traader[i].join();
      }
    } catch (InterruptedException e) {}

    System.out.println("Totalt antall traader: " + antallTraader);
  }

  @Override public void run(){
    laas.lock();
    int id =  antallTraader;
    antallTraader++;
    laas.unlock();
    System.out.println("Traad ID: " + id + ".");
  }

}
