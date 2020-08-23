import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Traadklasse10{

Condition ikkeNeste;
Condition provIgjen;
Lock lock;

  public Traadklasse10(){
    lock = new ReentrantLock();
    ikkeNeste = lock.newCondition();
    provIgjen = lock.newCondition();
    Monitor m = new Monitor();

    for (int i = 0; i < 10; i++){
      new Thread(new Traadklassen(i, 0, 1000, m)).start();
    }
  }

  public static void main(String[] args){
    new Traadklasse10();
  }

  class Monitor{

  int tall = -1;

    public void skrivUt(int i){
      lock.lock();

      try{
        while (i - 1 != tall){
          ikkeNeste.await();
        }
        tall = i;
        System.out.println(tall);
        ikkeNeste.signalAll();
      } catch (InterruptedException e){
        System.out.println("Feil.");
      } finally{
        lock.unlock();
      }
    }

  }

}

class Traadklassen implements Runnable{

int n;
int start;
int maks;
Traadklasse10.Monitor monitor;
Lock lock = new ReentrantLock();

  public Traadklassen(int n, int start, int maks,
  Traadklasse10.Monitor monitor){
    this.n = n;
    this.start = start;
    this.maks = maks;
    this.monitor = monitor;
  }

  public void run(){
    lock.lock();

    try{
      for (int i = start; i <= maks; i *= n){
        monitor.skrivUt(i);
      }
    } finally{
      lock.unlock();
    }
  }

}
