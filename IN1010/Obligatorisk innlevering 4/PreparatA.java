public class PreparatA extends Legemiddel{

int styrke;

  public PreparatA(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentNarkotiskStyrke(){
    return styrke;
  }

  @Override public String toString(){
    return "Navn: '" + navn + "', pris: '" + pris + "', virkestoff: '" +
    virkestoff + "', styrke: '" + styrke + "'.";
  }

}
