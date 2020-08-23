public class Person{

private String navn;
private int alder;

  public Person(String navn, int alder){
    this.navn = navn;
    this.alder = alder;
  }

  public String hentNavn(){
    return navn;
  }

  public int hentAlder(){
    return alder;
  }

  @Override public String toString(){
    return navn + " ("+ alder + ")";
  }

}
