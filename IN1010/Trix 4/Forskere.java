public class Forskere extends Person{

String navn;
int alder;
int timeslonn;
String fagomraade;

public Forskere(String navn, int alder, int timeslonn, String fagomraade){
  super(navn, alder);
  this.navn = navn;
  this.alder = alder;
  this.timeslonn = timeslonn;
  this.fagomraade = fagomraade;
}

}
