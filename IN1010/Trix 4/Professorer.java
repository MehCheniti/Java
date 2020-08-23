public class Professorer extends Forskere{

String navn;
int alder;
int timeslonn;
String fagomraade;
String kurs;

public Professorer(String navn, int alder, int timeslonn, String fagomraade,
String kurs){
  super(navn, alder, timeslonn, fagomraade);
  this.navn = navn;
  this.alder = alder;
  this.timeslonn = timeslonn;
  this.fagomraade = fagomraade;
  this.kurs = kurs;
}

}
