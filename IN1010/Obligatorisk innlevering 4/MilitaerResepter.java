public class MilitaerResepter extends HviteResepter{

  public MilitaerResepter(Legemiddel legemiddel, Lege utskrivendeLege,
  Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public String farge(){
    return "hvit";
  }

  public double prisAaBetale(){
    return 0;
  }

  @Override public String toString(){
    return "Legemiddel - " + legemiddel + "\nUtskrivende lege - " +
    utskrivendeLege + " Pasient: '" + pasient + "', reit: '" + reit +
    "'.";
  }

}
