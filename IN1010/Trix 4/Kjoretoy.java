public class Kjoretoy{

String registreringsnummer;
String fabrikkmerke;
String navn;

public Kjoretoy(String registreringsnummer, String fabrikkmerke, String navn){
  this.registreringsnummer = registreringsnummer;
  this.fabrikkmerke = fabrikkmerke;
  this.navn = navn;
}

public String skrivUt(){
  return this.fabrikkmerke;
}

}
