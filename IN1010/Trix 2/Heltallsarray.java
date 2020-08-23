import java.util.ArrayList;

public class Heltallsarray{

  public static void main(String[] args){
    int tall1 = 0;
    int tall2 = 1;
    int tall3 = 2;
    int tall4 = 3;
    int tall5 = 4;
    System.out.println(tall1);
    System.out.println(tall2);
    System.out.println(tall3);
    System.out.println(tall4);
    System.out.println(tall5);
    ArrayList<Integer> listeAvTall = new ArrayList<Integer>();
    listeAvTall.add(tall1);
    listeAvTall.add(tall2);
    listeAvTall.add(tall3);
    listeAvTall.add(tall4);
    listeAvTall.add(tall5);
    for (int tall : listeAvTall){
      System.out.println(tall);
    }

  }
}
