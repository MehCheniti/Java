public class BlaaResepter extends Resept{

  public BlaaResepter(Legemiddel legemiddel, Lege utskrivendeLege,
  int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }

  public String farge(){
    return "blaa";
  }

  public double prisAaBetale(){
    return legemiddel.hentPris() - (legemiddel.hentPris() * 0.75);
  }

  @Override public String toString(){
    return "Legemiddel - " + legemiddel + "\nUtskrivende lege - " +
    utskrivendeLege + " Pasient ID: '" + pasientId + "', reit: '" + reit +
    "'.";
  }

}
