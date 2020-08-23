public class BlaaResepter extends Resept{

  public BlaaResepter(Legemiddel legemiddel, Lege utskrivendeLege,
  Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public String farge(){
    return "blaa";
  }

  public double prisAaBetale(){
    return legemiddel.hentPris() - (legemiddel.hentPris() * 0.75);
  }

  @Override public String toString(){
    return "Legemiddel - " + legemiddel + "\nUtskrivende lege - " +
    utskrivendeLege + " Pasient: '" + pasient + "', reit: '" + reit +
    "'.";
  }

}
