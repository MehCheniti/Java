public class Motorsykkel extends Kjoretoy{

  int personKapasitet;
  int sjaaforKapasitet;

  public Motorsykkel(int kapasitet){
    super(kapasitet);
  }

  public Boolean sjekkKapasitet(){
    if (kapasitet == 1) {
      return true;
    } else {
      return false;
    }
  }

  public void settInPerson(Person person){
    personKapasitet++;
    kapasitet++;
  }

  public void settInSjaafor(Sjaafor sjaafor){
    sjaaforKapasitet++;
    kapasitet++;
  }

}
