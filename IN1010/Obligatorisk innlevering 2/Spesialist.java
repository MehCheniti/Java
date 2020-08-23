public class Spesialist extends Lege implements Godkjenningsfritak{

  public Spesialist(String navn, int kontrollID){
    super(navn);
    this.kontrollID = kontrollID;
  }

  public int hentKontrollID(){
    return kontrollID;
  }

  @Override public Resept skrivResept(Legemiddel legemiddel, int pasientID,
  int reit) throws UlovligUtskrift{
    Resept nyResept = new BlaaResepter(legemiddel, this, pasientID,
    reit);
    return nyResept;
  }

  @Override public String toString(){
    return "Navn: '" + navn + "', kontroll ID: '" + kontrollID + "'.";
  }

}
