class A{

  void skrivKlasse(){
    System.out.println("A.");
  }

}

class B extends A{

  void skrivKlasse(){
    System.out.println("B.");
  }

}

class TestProgram{

  public static void main(String[] args){
    B b = new B();
    A b2 = new B();
    b.skrivKlasse();
    b2.skrivKlasse();
  }

}

class Bok {
    private String tittel;

    public Bok (String t) {
        tittel = t;
    }

    public String toString() {
        return tittel;
    }
}

class Bokhylle {
    private Bok[] boeker;

    public Bokhylle (int antPlasser) {
        boeker = new Bok[antPlasser];
    }

    //Forsoeker aa sette inn en bok paa foerste ledige plass i bokhyllen
    public void settInn(Bok b) throws DuplikatException, IkkeMerPlassException{

        for (int i = 0; i < boeker.length; i++) {
          if (boeker[i] != null && boeker[i].toString() == b.toString()) throw
          new DuplikatException(boeker[i].toString());

            if (boeker[i] == null) {

                boeker[i] = b;
                return;
            }
    }

    throw new IkkeMerPlassException(b.toString());
  }

    public void skrivBoeker() {
        for (Bok b: boeker) {
            if (b != null) {
                System.out.println(b);
            }
        }
    }
}

class TestBokhylle {

    public static void main(String[] args) {

        Bokhylle bokhylle = new Bokhylle(3);
        System.out.println("Setter inn boeker:");

        String[] titler = {"De doedes tjern", "Doppler", "Doppler", "Misery", "Gone with the Wind"};

        for (int i = 0; i < titler.length; i++) {

          try {
              bokhylle.settInn(new Bok(titler[i]));

          } catch (DuplikatException de) {
              System.out.println(de.getMessage());

          } catch (IkkeMerPlassException impe) {
              System.out.println(impe.getMessage());
          }
      }

        System.out.println("\nSkriver ut boeker:");
        bokhylle.skrivBoeker();
    }
} // Siden bokhyllen ble opprettet med 3 plasser, ble det kun satt inn 3
// Bok-objekter.

class IkkeMerPlassException extends Exception{

String boktittel;

  IkkeMerPlassException(String boktittel){
    this.boktittel = boktittel;
    System.out.println("Det var ikke mer plass, gjelder tittelen " + boktittel
    + ".");
  }

}

class DuplikatException extends Exception{

String boktittel;

  DuplikatException(String boktittel){
    this.boktittel = boktittel;
    System.out.println("Boken var et duplikat.");
  }

}

interface rovdyr{

  void jakte();

}

interface planteeter{

  void beskytte();

}

class Bjorn implements rovdyr{

  public void jakte(){
    System.out.println("Jeg jakter.");
  }

}

class Ulv implements rovdyr{

  public void jakte(){
    System.out.println("Jeg jakter.");
  }

}

class Elg implements planteeter{

  public void beskytte(){
    System.out.println("Jeg beskytter meg selv.");
  }

}

class Sau implements planteeter{

  public void beskytte(){
    System.out.println("Jeg beskytter meg selv.");
  }

}

class TestProgram2{

  public static void main(String[] args){
    Bjorn bjorn = new Bjorn();
    Ulv ulv = new Ulv();
    Elg elg = new Elg();
    Sau sau = new Sau();

    rovdyr[] rovdyr = {bjorn, ulv};
    planteeter[] planteetere = {elg, sau};

    for (int i = 0; i < rovdyr.length; i++){
      rovdyr[i].jakte();
    }

    for (int i = 0; i < planteetere.length; i++){
      planteetere[i].beskytte();
    }
  }

}

abstract class Hest {
    String navn;
    int alder;

    public Hest(String n, int a) {
        navn = n;
        alder = a;
    }

    public void skritt() {
        System.out.println(navn + " gaar fremover.");
    }

    public void trav() {
        System.out.println(navn + " 'jogger' med hoyre fremben og venstre bakben, deretter motsatt.");
    }

    public void galopp() {
        System.out.println(navn + " beveger seg raskt med beina i tretakt.");
    }
}

class EngelskFullblodhest extends Hest{

  public EngelskFullblodhest(String navn, int alder){
    super(navn, alder);
  }

}

interface KanToelte{

  public void toelt();

}

interface KanPasse{

  public void pass();

}

class PasoFino extends Hest implements KanToelte{

  public PasoFino(String navn, int alder){
    super(navn, alder);
  }

  public void toelt(){
    System.out.println("Hesten skritter i raskt temp.");
  }

}

class Islandshest extends Hest implements KanToelte, KanPasse{

  public Islandshest(String navn, int alder){
    super(navn, alder);
  }

  public void toelt(){
    System.out.println("Hesten skritter i raskt temp.");
  }

  public void pass(){
    System.out.println("Hesten svever.");
  }

}

class TestProgram3{

  public static void main(String[] args){
    EngelskFullblodhest ef = new EngelskFullblodhest("Engelsk", 17);
    PasoFino pf = new PasoFino("Paso", 19);
    Islandshest ih = new Islandshest("Island", 20);

    ef.trav();
    pf.toelt();
    ih.toelt();
    ih.pass();
  }

}

interface Figur{

  double beregnAreal();

  double beregnOmkrets();

}

class Rektangel implements Figur{

private double hoyde;
private double bredde;

  public Rektangel(double hoyde, double bredde){
    this.hoyde = hoyde;
    this.bredde = bredde;
  }

  public double beregnAreal(){
    return hoyde * bredde;
  }

  public double beregnOmkrets(){
    return hoyde + bredde;
  }

}

class Sirkel implements Figur{

private double radius;

  public Sirkel(double radius){
    this.radius = radius;
  }

  public double beregnAreal(){
    return Math.PI * Math.pow(radius, 2);
  }

  public double beregnOmkrets(){
    return (radius * 2) * Math.PI;
  }

}

class TestProgram4{

  public static void main(String[] args){
    Rektangel r = new Rektangel(17, 20);
    Sirkel s = new Sirkel(19);

    System.out.println(r.beregnAreal());
    System.out.println(r.beregnOmkrets());
    System.out.println(s.beregnAreal());
    System.out.println(s.beregnOmkrets());
  }

}

// 5.06) Nei, fordi det finns ingen måte å relatere superklassene på.
// Ja.
