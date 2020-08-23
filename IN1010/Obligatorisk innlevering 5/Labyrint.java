import java.io.*;
import java.util.*;

public class Labyrint{

Rute[][] toDArray;
int rader;
int kolonner;
Lenkeliste<String> vei;
boolean vertHer = false;

  private Labyrint(Rute[][] toDArray, int rader, int kolonner){
    this.toDArray = toDArray;
    this.rader = rader;
    this.kolonner = kolonner;
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException{
    Scanner inp = new Scanner(fil);
    String inp2 = inp.nextLine();
    String[] str = inp2.split(" ");
    int rad = Integer.parseInt(str[0]);
    int kolonne = Integer.parseInt(str[1]);
    Rute[][] brett = new Rute[rad][kolonne];
    Rute rute;

    for (int i = 0; i < rad; i++){
      inp2 = inp.nextLine();
      str = inp2.split("");
      for (int j = 0; j < kolonne; j++){
        if (str[j].equals(".")){
          if (erAapen(i, j, rad, kolonne)){
            brett[i][j] = new Aapning(i, j);
          } else{
            brett[i][j] = new HvitRute(i, j);
          }
        } else{
          brett[i][j] = new SortRute(i, j);
        }
      }
    }

    Labyrint l = new Labyrint(brett, rad, kolonne);

    for (int r = 0; r < rad; r++){
      for (int k = 0; k < kolonne; k++){
        settNabo(brett[r][k], brett, rad, kolonne);
        brett[r][k].settLabyrint(l);
      }
    }

    return l;
  }

  public static void settNabo(Rute rute, Rute[][] brett, int rader,
  int kolonner){
    int i = rute.hentRad();
    int j = rute.hentKolonne();

    if (j > 0){
      rute.settVest(brett[i][j - 1]);
    }

    if (j < (kolonner - 1)){
      rute.settOst(brett[i][j + 1]);
    }

    if (i > 0){
      rute.settNord(brett[i - 1][j]);
    }

    if (i < (rader - 1)){
      rute.settSyd(brett[i + 1][j]);
    }

  }

  public static boolean erAapen(int rad, int kolonne, int rader, int kolonner){
    if (rad == 0 || kolonne == 0 || rad == (rader - 1) || kolonne ==
    (kolonner - 1)){
      return true;
    } else{
      return false;
    }
  }

  public Lenkeliste<String> hentVei(){
    return vei;
  }

  public boolean hentVertHer(){
    return vertHer;
  }

  public Lenkeliste<String> finnUtveiFra(int kol, int rad){
    vei = new Lenkeliste<String>();
    Rute rute = toDArray[rad][kol];
    rute.gaa(null, "");
    return vei;
  }

  @Override public String toString(){
    String str = "";

    for (Rute[] i : toDArray){
      for (Rute j : i){
        str += j.tilTegn();
      }
      str += "\n";
    }
    return str;
  }

}
