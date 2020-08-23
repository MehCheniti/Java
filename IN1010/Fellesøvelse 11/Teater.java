import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Teater{

private int antPersoner;
private Lock lock = new ReentrantLock();

  public Teater(int antPersoner){
    this.antPersoner = antPersoner;
  }

  public void gaaInn(){
    lock.lock();

    try{
      antPersoner++;
      System.out.println("Gikk inn, naa: " + antPersoner + ".");
    } finally{
      lock.unlock();
    }
  }

  public void gaaUt(){
    lock.lock();

    try{
      antPersoner--;
      System.out.println("Gikk ut, naa: " + antPersoner + ".");
    } finally{
      lock.unlock();
    }
  }

}
