class SySammen implements Runnable{

private Samlebaand samlebaand;
private int produksjonsMaal;

  public SySammen(Samlebaand baand, int maal){
    samlebaand = baand;
    produksjonsMaal = maal;
  }

  @Override public void run(){
    System.out.println("Syerske starter!");

    try{
      for (int i = 0; i < produksjonsMaal; i++){
        samlebaand.taAvBaand();
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {}

    System.out.println("Syersken har naadd produksjonsmaalet.");
  }

}
