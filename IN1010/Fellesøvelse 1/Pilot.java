public class Pilot {

  private String navn;
  private static int antallTurer = 0;
  private int totalDistanse = 0;

  public Pilot(String navn){
    this.navn = navn;
  }

  public String hentNavn(){
    return navn;
  }

  public int hentAntallTurer(){
    return antallTurer;
  }

  public int hentTotalDistanse(){
    return totalDistanse;
  }

  public void leggTilFlyvning(int km){
    totalDistanse += km;
    antallTurer++;
  }

  public double hentGjenomsnittligDistanse(){
    return totalDistanse / antallTurer;
  }

}
