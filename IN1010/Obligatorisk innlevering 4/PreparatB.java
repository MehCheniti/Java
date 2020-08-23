public class PreparatB extends Legemiddel{

int styrke;

  public PreparatB(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentVanedannendeStyrke(){
    return styrke;
  }

  @Override public String toString(){
    return "Navn: '" + navn + "', pris: '" + pris + "', virkestoff: '" +
    virkestoff + "', styrke: '" + styrke + "'.";
  }

}
