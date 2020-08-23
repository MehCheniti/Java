public class Emne{

private String kode;
private String navn;
private boolean masteremne;

  public Emne(String kode, String navn, boolean masteremne){
    this.kode = kode;
    this.navn = navn;
    this.masteremne = masteremne;
  }

  public boolean erMasteremne(){
    return masteremne;
  }

  @Override public String toString(){
    return kode + ", " + navn;
  }

}
