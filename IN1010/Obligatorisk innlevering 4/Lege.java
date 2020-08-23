public class Lege implements Comparable<Lege>{

String navn;
int kontrollID;
Lenkeliste<Resept> utskrevendeResepter = new Lenkeliste<Resept>();

  public Lege(String navn){
  this.navn = navn;
  }

  public String hentNavn(){
    return navn;
  }

  public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit)
  throws UlovligUtskrift{
    Resept nyResept = new BlaaResepter(legemiddel, this, pasient, reit);
    utskrevendeResepter.leggTil(nyResept);
    pasient.resepter.leggPaa(nyResept);

    if (legemiddel instanceof PreparatA){
      throw new UlovligUtskrift(this, legemiddel);
    } else{
      return nyResept;
    }
  }

  @Override public String toString(){
    return "Navn: '" + navn + "'.";
  }

  public int compareTo(Lege lege){
    return navn.compareTo(lege.hentNavn());
  }

  public Lenkeliste<Resept> hentResept(){
    return utskrevendeResepter;
  }

}
