import java.util.concurrent.CountDownLatch;

public class Kryptograf implements Runnable{

private TelegrafistMonitor telegrafistMonitor;
private KryptografMonitor kryptografMonitor;
private CountDownLatch latch;
private static int antallKryptografer = 0;
private final int kryptografID;

  public Kryptograf(TelegrafistMonitor telegrafistMonitor,
  KryptografMonitor kryptografMonitor, CountDownLatch latch){
    this.telegrafistMonitor = telegrafistMonitor;
    this.kryptografMonitor = kryptografMonitor;
    this.latch = latch;
    this.kryptografID = antallKryptografer++;
  }

  public void run(){
    try{
      Melding kryptertMelding = telegrafistMonitor.hentMelding();
      while (!telegrafistMonitor.hentSlutt() || kryptertMelding != null){
        System.out.println("Kryptograf " + kryptografID +
        " dekrypterer en ny melding.");
        String dekryptertInnhold =
        Kryptografi.dekrypter(kryptertMelding.hentInnhold());
        Melding dekryptertMelding = new Melding(dekryptertInnhold,
        kryptertMelding.hentSekvensnummer(), kryptertMelding.hentID());
        kryptografMonitor.leggTilMelding(dekryptertMelding);
        kryptertMelding = telegrafistMonitor.hentMelding();
      }
    } catch (InterruptedException e) {}

    kryptografMonitor.slutt();
    latch.countDown();
  }

}
