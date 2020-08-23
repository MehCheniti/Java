import java.util.concurrent.CyclicBarrier;

class Traader implements Runnable{

private CyclicBarrier barrier;

  public Traader(CyclicBarrier barrier){
    this.barrier = barrier;
  }

  public void run(){
    try{
      System.out.println("Hei. 1");
      try{
        barrier.await();
      } catch (Exception e) {}
      System.out.println("Hei. 2");
      try{
        barrier.await();
      } catch (Exception e) {}
      System.out.println("Hei. 3");
    } catch (Exception e) {}
  }

}

class Hovedprogram{

  public static void main(String[] args){
    int antallTraader = 8;
    CyclicBarrier barrier = new CyclicBarrier(antallTraader);
    Traader t = new Traader(barrier);

    for (int i = 0; i < antallTraader; i++){
      new Thread(t).start();
    }
  }

}
