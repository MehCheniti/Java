public class Masterstudent extends Student{

String navn;
int alder;
String kurs;
String laerested;

public Masterstudent(String navn, int alder, String kurs, String laerested){
  super(navn, alder, kurs, laerested);
  this.navn = navn;
  this.alder = alder;
  this.kurs = kurs;
  this.laerested = laerested;
}

}
