import java.util.concurrent.CountDownLatch;

public class Parallel{

  public static int finnMax(int[] original, int numThreads){
    int[] resultater = new int[numThreads];
    Thread[] threads = new Thread[numThreads];
    CountDownLatch latch = new CountDownLatch(numThreads);
    int start = 0;
    int seksjonsLengde = original.length / numThreads;

    for (int i = 0; i < threads.length; i++){
      int slutt = start + seksjonsLengde;
      threads[i] = new Thread(new Worker(i, latch, original, resultater, start,
      slutt));
      start = slutt;
    }

    threads[numThreads - 1] = new Thread(new Worker(numThreads - 1, latch,
    original, resultater, start, original.length));

    for (int i = 0; i < threads.length; i++){
      threads[i].start();
    }

    // Main tråd må vente til alle andre er ferdige.

    try{
      latch.await();
    } catch(Exception e){
      e.printStackTrace();
    }

    int storst = 0;

    for (int i = 0; i < resultater.length; i++){
      if (resultater[i] > storst){
        storst = resultater[i];
      }
    }

    return storst;
  }

}
