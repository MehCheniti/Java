class Pasient{

String navn;
String fodselsnummer;
int ID;
static int teller = 0;
Stabel<Resept> resepter = new Stabel<Resept>();

  public Pasient(String navn, String fodselsnummer){
    this.navn = navn;
    this.fodselsnummer = fodselsnummer;
    ID = teller++;
  }

  public String hentNavn(){
    return navn;
  }

  public String hentFodselsnummer(){
    return fodselsnummer;
  }

  public void leggTilResept(Resept resept){
    resepter.leggPaa(resept);
  }

  public Stabel<Resept> hentUtResept(){
    return resepter;
  }

  public int hentId(){
    return ID;
  }

  @Override public String toString(){
    return "Navn: '" + navn + "', fodselsnummer: '" + fodselsnummer + "'.";
  }

}
