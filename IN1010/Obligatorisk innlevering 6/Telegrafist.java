import java.util.concurrent.CountDownLatch;

public class Telegrafist implements Runnable{

private Kanal kanal;
private String innhold;
private int sekvensnummer = 0;
private int kanalID;
private TelegrafistMonitor monitor;
private CountDownLatch latch;
private static int antallTelegrafister = 0;
private final int telegrafistID;

  public Telegrafist(Kanal kanal, TelegrafistMonitor monitor,
  CountDownLatch latch, int kanalID){
    this.kanal = kanal;
    this.monitor = monitor;
    this.latch = latch;
    this.kanalID = kanalID;
    this.telegrafistID = antallTelegrafister++;
  }

  public void run(){
    try{
      innhold = kanal.lytt();
      while (innhold != null){
        Melding melding = new Melding(innhold, sekvensnummer++, kanalID);
        System.out.println("Telegrafist " + telegrafistID +
        " sender en ny melding.");
        monitor.leggTilMelding(melding);
        innhold = kanal.lytt();
      }
      latch.countDown();
      System.out.println("Telegrafist " + telegrafistID + " har sluttet.");
      latch.await();
    } catch (InterruptedException e) {}

    monitor.slutt();
  }

}
