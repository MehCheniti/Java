public abstract class Flybillett{

  private String sete;
  private Avgang avgang;

  public Flybillett(String sete, Avgang avgang){
    this.sete = sete;
    this.avgang = avgang;
  }

  public String hentSete(){
    return sete;
  }

  public Avgang hentAvgang(){
    return avgang;
  }

}
