import java.util.*;

public class Katt{

String navn;
int alder;

  public Katt(String navn, int alder){
    this.navn = navn;
    this.alder = alder;
  }

  public int compareTo (Katt annen){
    if (this.alder < annen.alder){
      return -1;
    } else if (this.alder > annen.alder){
      return 1;
    } else{
      return 0;
    }
  }

  @Override public String toString(){
    return "Navn: " + navn + ", alder: " + alder + ".";
  }

  public static void main(String[] args){
    ArrayList<Katt> katter = new ArrayList<Katt>();

    Katt katt1 = new Katt("Mehdi", 19);
    Katt katt2 = new Katt("Magali", 20);

    katter.add(katt1);
    katter.add(katt2);

    Katt eldst = katter.get(0);
    for (Katt i : katter){
      if (i.compareTo(eldst) > 0){
        eldst = i;
      }
    }
    System.out.println(eldst);
  }

}
