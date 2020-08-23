public class TestBUES{
  public static void main(String[] args){

    Bjorn b = new Bjorn();
    Ulv u = new Ulv();
    Elg e = new Elg();
    Sau s = new Sau();

    Rovdyr[] rovdyr = new Rovdyr[2];
    Planteetere[] planteetere = new Planteetere[2];

    rovdyr[0] = b;
    rovdyr[1] = u;
    planteetere[0] = e;
    planteetere[1] = s;

    for (Rovdyr r : rovdyr){
      r.jakte();
    }
    for (Planteetere p : planteetere){
      p.beskytteSeg();
    }

  }
}
