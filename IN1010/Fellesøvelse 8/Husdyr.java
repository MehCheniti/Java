public abstract class Husdyr implements LagerLyd{

protected String navn;
protected int alder;
protected int id;
private static int teller = 0;

  public Husdyr(String navn, int alder){
    this.navn = navn;
    this.alder = alder;
    id = teller;
    teller++;
  }

  public int hentAlder(){
    return alder;
  }

  public String hentNavn(){
    return navn;
  }

  @Override public String toString(){
    return "Alder: " + alder + ", navn: " + navn + ".";
  }

  public void oppdaterAlder(){
    alder++;
  }

  public void oppdaterAlder(int nyAlder){
    alder = nyAlder;
  }

  public int hentId(){
    return id;
  }

}
