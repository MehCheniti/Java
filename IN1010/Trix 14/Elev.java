import java.util.concurrent.CountDownLatch;

class Elev implements Runnable{

boolean[] stemmeboks;
int nummer;
CountDownLatch vent;

  public Elev(boolean[] stemmeboks, int nummer, CountDownLatch vent){
    this.stemmeboks = stemmeboks;
    this.nummer = nummer;
    this.vent = vent;
  }

  public void run(){
    if (nummer % 5 == 3){
      stemmeboks[nummer] = true;
    } else{
      stemmeboks[nummer] = false;
    }

    vent.countDown();
  }

}
