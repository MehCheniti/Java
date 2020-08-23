public class Bil implements HarAlder{

private String bilnr;
private int alder;

  public Bil(String bilnr, int alder){
    this.bilnr = bilnr;
    this.alder = alder;
  }

  public int hentAlder(){
    return alder;
  }

}
