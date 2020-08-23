public class Busser extends Kjoretoy{

String registreringsnummer;
String fabrikkmerke;
String navn;

public Busser(String registreringsnummer, String fabrikkmerke, String navn){
  super(registreringsnummer, fabrikkmerke, navn);
  this.registreringsnummer = registreringsnummer;
  this.fabrikkmerke = fabrikkmerke;
  this.navn = navn;
}

public String skrivUt(){
  return this.fabrikkmerke;
}

}
