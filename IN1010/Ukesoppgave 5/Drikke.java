public class Drikke implements Drikkbar{

int maksStr;
int volum;

  public Drikke(int maksStr){
  this.maksStr = maksStr;
  this.volum = volum;
  volum = maksStr;
  }

  public void drikkGlass(){
    volum -= 2;
    if (volum < 2){
      volum = 0;
    }
  }

  public void fyllOpp(){
    volum = maksStr;
  }

  @Override public String toString(){
    return "Volum: " + volum + ".";
  }

}
