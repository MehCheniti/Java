import java.util.concurrent.CountDownLatch;

public class Hovedprogram{

  public static void main(String[] args){
    int antallTelegrafister = 3;
    int antallKryptografer = 5;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();

    TelegrafistMonitor monitorKryptert = new TelegrafistMonitor();
    KryptografMonitor monitorDekryptert = new KryptografMonitor();

    CountDownLatch laasTelegrafist = new CountDownLatch(antallTelegrafister);
    CountDownLatch laasKryptograf = new CountDownLatch(antallKryptografer);

    Runnable operasjonsleder = new Operasjonsleder(monitorDekryptert,
    antallTelegrafister);

    for (int i = 0; i < antallTelegrafister; i++){
      new Thread(new Telegrafist(kanaler[i], monitorKryptert, laasTelegrafist,
      i)).start();
    }

    for (int i = 0; i < antallKryptografer; i++){
      new Thread(new Kryptograf(monitorKryptert, monitorDekryptert,
      laasKryptograf)).start();
    }

    try{
      laasTelegrafist.await();
      laasKryptograf.await();
    } catch (InterruptedException e) {}

    new Thread(operasjonsleder).start();

    System.out.println("INGEN FLERE MELDINGER.");
  }

}
