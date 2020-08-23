public class Bachelorstudent extends Student{

String navn;
int alder;
String kurs;
String laerested;

public Bachelorstudent(String navn, int alder, String kurs, String laerested){
  super(navn, alder, kurs, laerested);
  this.navn = navn;
  this.alder = alder;
  this.kurs = kurs;
  this.laerested = laerested;
}

}
