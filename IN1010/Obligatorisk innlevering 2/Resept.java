public abstract class Resept{

  static int teller = 0;
  int id;
  Legemiddel legemiddel;
  Lege utskrivendeLege;
  int pasientId;
  int reit;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege,
  int pasientId, int reit){
    id = teller++;
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
  }

  public int hentId(){
    return id;
  }

  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return utskrivendeLege;
  }

  public int hentPasientId(){
    return pasientId;
  }

  public int hentReit(){
    return reit;
  }

  public boolean bruk(){
    if (reit > 0){
      reit--;
      return true;
    } else{
      return false;
    }
  }

  abstract public String farge();

  abstract public double prisAaBetale();

}
