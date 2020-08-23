class KlippTil implements Runnable{

private Samlebaand samlebaand;
private int produksjonsMaal;

  public KlippTil(Samlebaand baand, int maal){
    samlebaand = baand;
    produksjonsMaal = maal;
  }

  public void run(){
    System.out.println("Klipper starter!");

    try{
      for (int i = 0; i < produksjonsMaal; i++){
        Thread.sleep(500);
        samlebaand.taAvBaand();
      }
    } catch (InterruptedException e) {}

    System.out.println("Klipper har naadd produksjonsmaalet.");
  }

}
