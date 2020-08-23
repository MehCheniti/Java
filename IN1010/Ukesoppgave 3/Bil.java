public class Bil extends Kjoretoy{

  int personKapasitet;
  int sjaaforKapasitet;

  public Bil(int kapasitet){
    super(kapasitet);
  }

  public Boolean sjekkKapasitet(){
    if (kapasitet >= 2 && kapasitet <= 5) {
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
