public class Lege{

  String navn;
  int kontrollID;

  public Lege(String navn){
  this.navn = navn;
  }

  public String hentNavn(){
    return navn;
  }

  public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit)
  throws UlovligUtskrift{
    Resept nyResept = new BlaaResepter(legemiddel, this, pasientID, reit);
    if (legemiddel instanceof PreparatA){
      throw new UlovligUtskrift(this, legemiddel);
    } else{
      return nyResept;
    }
  }

  @Override public String toString(){
    return "Navn: '" + navn + "'.";
  }

}
