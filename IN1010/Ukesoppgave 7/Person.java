public class Person implements Comparable<Person>{

String navn;
String etternavn;
int alder;

  public Person(String navn, String etternavn, int alder){
    this.alder = alder;
    this.navn = navn;
    this.etternavn = etternavn;
  }

  public int compareTo(Person p){
    if (alder == p.hentAlder()){
      return this.toString().compareTo(p.toString());
    }
    return alder - p.hentAlder();
  }

  @Override public String toString(){
    return etternavn + navn + alder;
  }

  public int hentAlder(){
    return alder;
  }

}
