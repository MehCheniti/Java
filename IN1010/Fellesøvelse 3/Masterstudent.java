public class Masterstudent extends Student{

private Person veileder;

  public Masterstudent(String navn, int alder){
    super(navn, alder);
  }

  public Masterstudent(String navn, int alder, Person veil){
    super(navn, alder);
    veileder = veil; // Kan også skrive this.veileder.
  }

  @Override public void registrer(Emne emne){
    emner.add(emne);
  }

  @Override public String toString(){
    return super.toString() + "\n - Veileder: " + veileder;
  }

}
