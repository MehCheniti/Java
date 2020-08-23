public class Ol extends Drikke{

  public Ol(int maksStr){
  super(maksStr);
  }

  @Override public void drikkGlass(){
    volum -= 5;
    if (volum < 2){
      volum = 0;
    }
  }

  @Override public void fyllOpp(){
    volum = maksStr;
  }

  @Override public String toString(){
    return "Volum: " + volum + ".";
  }

}
