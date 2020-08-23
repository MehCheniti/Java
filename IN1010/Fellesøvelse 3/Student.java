import java.util.ArrayList;

public abstract class Student extends Person{

protected ArrayList<Emne> emner = new ArrayList<Emne>();

  public Student(String navn, int alder){
    super(navn, alder);
    emner = new ArrayList<Emne>();
  }
  public abstract void registrer(Emne emne);

  @Override public String toString(){
    return  super.toString() + " tar " + emner;
  }

}
