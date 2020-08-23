public class Sjaafor extends Person{

  public Sjaafor(String navn, int alder){
    super(navn, alder);
  }

  public Boolean sjekkAlder(){
    if (alder >= 18){
      return true;
    } else {
      return false;
    }
  }

}
