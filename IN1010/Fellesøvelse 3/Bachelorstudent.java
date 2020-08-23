public class Bachelorstudent extends Student{

  public Bachelorstudent(String navn, int alder){
    super(navn, alder);
  }

  public Bachelorstudent(String navn, int alder, Person veil){
    super(navn, alder);
  }

  @Override public void registrer(Emne emne){
    if (emne.erMasteremne()){
      throw new ManglendeForkunnskapUnntak("Er ikke kvalifisert for " + emne +
      ".");
    } else{
      emner.add(emne);
    }
  }

}
