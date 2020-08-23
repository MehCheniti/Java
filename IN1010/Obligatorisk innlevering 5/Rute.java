abstract class Rute{

int rad;
int kolonne;
Labyrint labyrint;
Rute vest;
Rute ost;
Rute nord;
Rute syd;

  public Rute(int rad, int kolonne){
    this.rad = rad;
    this.kolonne = kolonne;
  }

  public void gaa(Rute rute, String vei){
    String koordinater = "(" + kolonne + ", " + rad + ")";
    String str = "";

    if (rute != null){
      str += "-->";
    }

    str += koordinater;
    vei += str;

    if (labyrint.hentVertHer()){
      System.out.println("Rute: " + koordinater + ".");
    }

    if (rute != vest && vest != null){
      vest.gaa(this, vei);
    }

    if (rute != ost && ost != null){
      ost.gaa(this, vei);
    }

    if (rute != nord && nord != null){
      nord.gaa(this, vei);
    }

    if (rute != syd && syd != null){
      syd.gaa(this, vei);
    }
  }

  public int hentRad(){
    return rad;
  }

  public int hentKolonne(){
    return kolonne;
  }

  public void settLabyrint(Labyrint nyLabyrint){
    labyrint = nyLabyrint;
  }

  public void settVest(Rute nyRute){
    vest = nyRute;
  }

  public void settOst(Rute nyRute){
    ost = nyRute;
  }

  public void settNord(Rute nyRute){
    nord = nyRute;
  }

  public void settSyd(Rute nyRute){
    syd = nyRute;
  }

  abstract char tilTegn();

}
