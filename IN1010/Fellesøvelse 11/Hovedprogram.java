import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hovedprogram{

  public static void main(String[] args){
    int varISalen = 15;
    int nyePublikum = 20;
    int skuespillere = 2;

    Teater t = new Teater(varISalen);

    CyclicBarrier venterPaaPublikum = new CyclicBarrier(nyePublikum +
    skuespillere);
    CountDownLatch alleGaattUt = new CountDownLatch(varISalen);

    Skuespiller s1 = new Skuespiller(venterPaaPublikum, "\n Romeo!");
    new Thread(s1).start();
    Skuespiller s2 = new Skuespiller(venterPaaPublikum, "\n Oh Juliet!");
    new Thread(s2).start();

    for (int i = 0; i < varISalen; i++){
      Runnable r = new Runnable(){
        public void run(){
          t.gaaUt();
          alleGaattUt.countDown();
        }
      };
      Thread thread = new Thread(r);
      thread.start();

      // new Thread(r).start();.

    }

    try{
      alleGaattUt.await();
    } catch (Exception e) {}

    for (int i = 0; i < nyePublikum; i++){
      InniSalen publikum = new InniSalen(venterPaaPublikum, t);
      Thread thread = new Thread(publikum);
      thread.start();
    }
  }

}

class Skuespiller implements Runnable{

CyclicBarrier barriere;
String tekst;

  public Skuespiller(CyclicBarrier barriere, String tekst){
    this.barriere = barriere;
    this.tekst = tekst;
  }

  public void run(){
    try{
      barriere.await();
      System.out.println(tekst);
    } catch(Exception e) {}
  }

}

class InniSalen implements Runnable{

public CyclicBarrier barriere;
Teater t;

  public InniSalen(CyclicBarrier barriere, Teater t){
    this.barriere = barriere;
    this.t = t;
  }

  public void run(){
    try{
      t.gaaInn();
      barriere.await();
    } catch (Exception e) {}
  }

}
