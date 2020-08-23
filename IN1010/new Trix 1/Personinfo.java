class Personinfo{

  public static void main(String[] args){
    System.out.println("Mehdi.");
    System.out.println("976 19 804.");
    System.out.println("Trimveien 6.");
  }

}

class BoolskeVerdier{

  public static void main(String[] args){
    Boolean sann = true;
    Boolean usann = false;

    System.out.println(sann);
    System.out.println(usann);

    if (sann || usann) System.out.println("Forste test slo til!");
    else System.out.println("Noe gikk galt!");

    if (sann && usann) System.out.println("Noe gikk galt!");
    else System.out.println("Andre test slo ikke til!");
  }

}

class Rektangel {

  double lengde;
  double bredde;

  public Rektangel (double l, double b) {   // Konstruktør
    this.lengde = l;
    this.bredde = b;
  }

  public void oekLengde (int okning) {    // Oek lengden som angitt
    lengde += okning;
  }

  public void oekBredde (int okning) {    // Oek bredden som angitt
    bredde += okning;
  }

  public void redusereLengde(int redusering){
    lengde -= redusering;
  }

  public void redusereBredde(int redusering){
    bredde -= redusering;
  }

  public double areal () {     // Beregn mitt areal
    return lengde * bredde;
  }

  public double omkrets () {   // Beregn min omkrets
    return lengde + bredde;
  }

  public static void main(String[] args){
    Rektangel rektangel1 = new Rektangel(17, 34);
    Rektangel rektangel2 = new Rektangel(19, 38);

    System.out.println(rektangel1.areal());
    System.out.println(rektangel2.areal());

    rektangel1.oekLengde(17);
    rektangel2.oekBredde(34);

    System.out.println(rektangel1.omkrets());
    System.out.println(rektangel2.omkrets());
  }

}

class Baat {

    private static int antProd = 0;
    private int prodnr;
    private String merke;

    public Baat(String mrk) {
        prodnr = antProd;
        antProd++;
        merke = mrk;
    }

    public String hentInfo() {
        return "Produksjonsnummer: " + prodnr + ", merke: " + merke;
    }
}

class Baathus{

int antallPlasser;
Baat[] baatArray;

  public Baathus(int antallPlasser){
    this.antallPlasser = antallPlasser;
    baatArray = new Baat[antallPlasser];
  }

  public void settInn(Baat baat){
    int counter = 0;
    boolean sattInn = false;

    while (counter < baatArray.length && sattInn == false){
      if (baatArray[counter] == null){
        baatArray[counter] = baat;
        sattInn = true;
      }
      counter++;
    }

    if (sattInn != true) System.out.println("Full!");
  }

  public void skrivBaater(){
    for (Baat b : baatArray){
      if (b != null) System.out.println(b.hentInfo());
    }
  }

}

class TestBaathus{

  public static void main(String[] args){
    Baathus baathus = new Baathus(3);
    Baat baat1 = new Baat("baat1");
    Baat baat2 = new Baat("baat2");
    Baat baat3 = new Baat("baat3");

    baathus.settInn(baat1);
    baathus.settInn(baat2);
    baathus.settInn(baat3);
    baathus.settInn(baat1);
    baathus.skrivBaater();
  }

}

class Person {
    String navn;
    int alder;

    public Person(String n, int a){
      this.navn = n;
      this.alder = a;
    }
}

class Lokker{

  public static void main(String[] args){
    int counter = 0;

    while (counter < 10){
      System.out.println(counter);
      counter++;
    }
  }

}

class Bil{

private String eier;
private String merke;

  public Bil(String e, String m){
    this.eier = e;
    this.merke = m;
  }

  void skrivEierOgMerke(){
    System.out.println("Eier: " + eier + ". Merke: " + merke + ".");
  }

}

class Biltest {
    public static void main(String[] args) {
        Bil bil = new Bil("Mehdi", "MacLaren");
        bil.skrivEierOgMerke();
    }
}
