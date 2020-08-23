public class Personbiler extends Biler{

String registreringsnummer;
String fabrikkmerke;
String navn;

public Personbiler(String registreringsnummer, String fabrikkmerke, String navn){
  super(registreringsnummer, fabrikkmerke, navn);
  this.registreringsnummer = registreringsnummer;
  this.fabrikkmerke = fabrikkmerke;
  this.navn = navn;
}

public String skrivUt(){
  return this.fabrikkmerke;
}

}
