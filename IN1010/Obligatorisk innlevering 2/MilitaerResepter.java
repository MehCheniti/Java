public class MilitaerResepter extends HviteResepter{

  public MilitaerResepter(Legemiddel legemiddel, Lege utskrivendeLege,
  int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }

  public String farge(){
    return "hvit";
  }

  public double prisAaBetale(){
    return 0;
  }

  @Override public String toString(){
    return "Legemiddel - " + legemiddel + "\nUtskrivende lege - " +
    utskrivendeLege + " Pasient ID: '" + pasientId + "', reit: '" + reit +
    "'.";
  }

}
