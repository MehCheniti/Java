import java.io.*;
import java.util.*;

class Skattekart{

char[][] toDArray;
boolean skattFunnet = false;
int hoyde;
int bredde;

  private Skattekart(char[][] toDArray, int hoyde, int bredde){
    this.toDArray = toDArray;
    this.hoyde = hoyde;
    this.bredde = bredde;
  }

  static Skattekart lesInn(File f) throws FileNotFoundException{
    Scanner inp = new Scanner(f);
    String[] str = inp.nextLine().split(" ");
    int rad = Integer.parseInt(str[0]);
    int kolonne = Integer.parseInt(str[1]);
    char[][] brett = new char[rad][kolonne];

    for (int r = 0; r < rad; r++){
      String linje = inp.nextLine();
      for (int k = 0; k < kolonne; k++){
        brett[rad][kolonne] = linje.charAt(kolonne);
      }
    }

    Skattekart s = new Skattekart(brett, rad, kolonne);
    return s;
  }

  public void skrivUt(){
    for (int i = 0; i < toDArray.length; i++){
      for (int j = 0; j < toDArray[i].length; j++){
        if (skattFunnet){
          System.out.println(toDArray[i][j]);
        } else{
          System.out.println("X");
        }
      }
      System.out.println();
    }
  }

  public boolean sjekk(int kol, int rad){
    if ((toDArray[rad][kol]) == 'X'){
      skattFunnet = true;
    }
    return skattFunnet;
  }

}
