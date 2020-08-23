public class TestProgram{

  public static void main(String[] args){
    Beholder<Sirkel> sirkler = new Beholder<Sirkel>();
    Sirkel sirkel = new Sirkel(17);
    sirkler.settInn(sirkel);
    Kvadrat kvadrat = new Kvadrat(17);
    // sirkler.settInn(kvadrat);
  }

}
