public class Legemiddel{

static int teller = 0;
int id;
String navn;
double pris;
double virkestoff;

  public Legemiddel(String navn, double pris, double virkestoff){
    id = teller++;
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
  }

  public int hentId(){
    return id;
  }

  public String hentNavn(){
    return navn;
  }

  public double hentPris(){
    return pris;
  }

  public double hentVirkestoff(){
    return virkestoff;
  }

  public void settNyPris(double nyPris){
    pris = nyPris;
  }

}
