import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{

public int id;
public CountDownLatch latch;
public int[] original;
public int[] resultater;
public int start;
public int slutt;

  public Worker(int id, CountDownLatch latch, int[] original, int[] resultater,
  int start, int slutt){
    this.id = id;
    this.latch = latch;
    this.original = original;
    this.resultater = resultater;
    this.start = start;
    this.slutt = slutt;
  }

  @Override public void run(){
    int lokaltStorst = 0;

    for (int i = start; i < slutt; i++){
      if (original[i] > lokaltStorst){
        lokaltStorst = original[i];
      }
    }

    resultater[this.id] = lokaltStorst;
    latch.countDown();
  }

}
