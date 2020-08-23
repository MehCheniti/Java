public class PResepter extends HviteResepter{

  public PResepter(Legemiddel legemiddel, Lege utskrivendeLege,
  Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public String farge(){
    return "hvit";
  }

  public double prisAaBetale(){
    if (legemiddel.hentPris() > 0){
      return legemiddel.hentPris() - 116;
    } else{
      return 0;
    }
  }

  @Override public String toString(){
    return "Legemiddel - " + legemiddel + "\nUtskrivende lege - " +
    utskrivendeLege + " Pasient: '" + pasient + "', reit: '" + reit +
    "'.";
  }

}
