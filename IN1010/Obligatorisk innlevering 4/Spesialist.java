public class Spesialist extends Lege implements Godkjenningsfritak{

  public Spesialist(String navn, int kontrollID){
    super(navn);
    this.kontrollID = kontrollID;
  }

  public int hentKontrollID(){
    return kontrollID;
  }

  @Override public Resept skrivResept(Legemiddel legemiddel, Pasient pasient,
  int reit) throws UlovligUtskrift{
    Resept nyResept = new BlaaResepter(legemiddel, this, pasient, reit);
    return nyResept;
  }

  @Override public String toString(){
    return "Navn: '" + navn + "', kontroll ID: '" + kontrollID + "'.";
  }

}
