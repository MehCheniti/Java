public class Student extends Person{

String navn;
int alder;
String kurs;
String laerested;

public Student(String navn, int alder, String kurs, String laerested){
  super(navn, alder);
  this.navn = navn;
  this.alder = alder;
  this.kurs = kurs;
  this.laerested = laerested;
}

}
