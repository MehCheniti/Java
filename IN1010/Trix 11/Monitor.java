import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor{

Lock lock = new ReentrantLock();
int detMinste;
int detStorste;

  public Monitor(int detMinste, int detStorste){
    this.detMinste = detMinste;
    this.detStorste = detStorste;
  }

  public boolean settMinste(int m){
    lock.lock();

    try{
      detMinste = m;
      if (detMinste < detStorste){
        return true;
      } else{
        return false;
      }
    } finally{
      lock.unlock();
    }
  }

  public boolean settStorste(int s){
    lock.lock();

    try{
      detStorste = s;
      if (detMinste < detStorste){
        return true;
      } else{
        return false;
      }
    } finally{
      lock.unlock();
    }
  }

}

class Nedover implements Runnable{

Monitor monitor;
Lock lock = new ReentrantLock();
static int maxValue;
int teller = maxValue;

  public Nedover(int maxValue, Monitor monitor){
    this.maxValue = maxValue;
    this.monitor = monitor;
  }

  public void run(){
    lock.lock();

    try{
      while(teller > Oppover.minValue){
        System.out.println(maxValue--);
        monitor.settStorste(maxValue);
        teller--;
      }
    } finally{
      lock.unlock();
    }
  }

}

class Oppover implements Runnable{

Monitor monitor;
Lock lock = new ReentrantLock();
static int minValue;
int teller = 0;

  public Oppover(int minValue, Monitor monitor){
    this.minValue = minValue;
    this.monitor = monitor;
  }

  public void run(){
    lock.lock();

    try{
      while(teller < Nedover.maxValue){
        System.out.println(minValue++);
        monitor.settMinste(minValue);
        teller++;
      }
    } finally{
      lock.unlock();
    }
  }

}
