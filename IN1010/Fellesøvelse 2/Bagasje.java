public class Bagasje{

  private Double vekt;
  private Avgang avgang;

  public Bagasje(Double vekt, Avgang avgang){
    this.vekt = vekt;
    this.avgang = avgang;
  }

  public Double hentVekt(){
    return vekt;
  }

  public Avgang hentAvgang(){
    return avgang;
  }

}
