public class Varebiler extends Biler{

String registreringsnummer;
String fabrikkmerke;
String navn;

public Varebiler(String registreringsnummer, String fabrikkmerke, String navn){
  super(registreringsnummer, fabrikkmerke, navn);
  this.registreringsnummer = registreringsnummer;
  this.fabrikkmerke = fabrikkmerke;
  this.navn = navn;
}

public String skrivUt(){
  return this.fabrikkmerke;
}

}
