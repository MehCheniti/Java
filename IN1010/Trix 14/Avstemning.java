import java.util.concurrent.CountDownLatch;

class Avstemning{

  public static void main(String[] args){
    CountDownLatch vent = new CountDownLatch(435);
    boolean stemmeboks[] = new boolean[435];

    for (int i = 0; i < 435; i++){
      Runnable elev = new Elev(stemmeboks, i, vent);
      Thread t = new Thread(elev);
      t.start();
    }

    try{
      vent.await();
    } catch (InterruptedException E) {}

    int stemmerForPannekake = 0;

    for (boolean b : stemmeboks){
      if (b) stemmerForPannekake++;
    }

    System.out.println("Saa mange stemte for pannekaker " + stemmerForPannekake +
     ".");
  }

}
