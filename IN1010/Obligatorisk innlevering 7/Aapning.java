public class Aapning extends HvitRute{

  public Aapning(int rad, int kolonne){
    super(rad, kolonne);
  }

  @Override public void gaa(Rute rute, String vei){
    String koordinater = "(" + kolonne + ", " + rad + ")";
    String str = "";

    if (rute != null){
      str += "-->";
    }

    str += koordinater;
    vei += str;
    Lenkeliste<String> veier = labyrint.hentVei();
    veier.leggTil(vei);

    if (labyrint.hentVertHer()){
      System.out.println("Utvei: " + koordinater + ".");
    }
  }

}
