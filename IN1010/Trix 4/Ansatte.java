public class Ansatte extends Person{

String navn;
int alder;
int timeslonn;

public Ansatte(String navn, int alder, int timeslonn){
  super(navn, alder);
  this.navn = navn;
  this.alder = alder;
  this.timeslonn = timeslonn;
}

}
