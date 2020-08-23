public class KvadratBeholder {
    private Kvadrat kvadrat;

    public void settInn(Kvadrat kvadrat) {
        this.kvadrat = kvadrat;
    }

    public Kvadrat taUt() {
        return this.kvadrat;
    }
}

class Beholder{

private Sirkel sirkel;

  public void settInn(Sirkel sirkel){
    this.sirkel = sirkel;
  }

  public Sirkel taUt(){
    return this.sirkel;
  }

}

abstract class Figur{

  public abstract double areal();

}

class Kvadrat extends Figur{

double side;

  public Kvadrat(double side){
    this.side = side;
  }

  public double areal(){
    return side * side;
  }

}

class Sirkel extends Figur{

private double radius;

  public Sirkel(double radius){
    this.radius = radius;
  }

  public double areal(){
    return radius * radius * Math.PI;
  }

}

class TestProgram{

  public static void main(String[] args){
    Sirkel sirkel = new Sirkel(17);
    Kvadrat kvadrat = new Kvadrat(34);

    Beholder sirkler = new Beholder();

    sirkler.settInn(sirkel);
    // sirkler.settInn(kvadrat);
  }

}

class Bil{

int registreringsnummer;
int antallPassasjerseter;

  public Bil(int registreringsnummer, int antallPassasjerseter){
    this.registreringsnummer = registreringsnummer;
    this.antallPassasjerseter = antallPassasjerseter;
  }

}

class Motorsykkel{

int registreringsnummer;
int motorstorrelse;

  public Motorsykkel(int registreringsnummer, int motorstorrelse){
    this.registreringsnummer = registreringsnummer;
    this.motorstorrelse = motorstorrelse;
  }

}

class Parkeringsplass<G>{

G node;

  public void settInn(G element){
    this.node = element;
  }

  public G taUt(){
    G temp = this.node;
    this.node = null;
    return temp;
  }

}

class TestProgram2{

  public static void main(String[] args){
    Parkeringsplass<Bil> parkeringsplass1 = new Parkeringsplass<Bil>();
    Parkeringsplass<Motorsykkel> parkeringsplass2 = new
    Parkeringsplass<Motorsykkel>();

    Bil bil = new Bil(17, 170);
    Motorsykkel motorsykkel = new Motorsykkel(34, 340);

    parkeringsplass1.settInn(bil);
    parkeringsplass2.settInn(motorsykkel);

    // parkeringsplass2.settInn(bil);
  }

}

class Parkeringshus{

  public static void main(String[] args){
    Parkeringsplass[] etasje1 = new Parkeringsplass[10];
    Parkeringsplass[] etasje2 = new Parkeringsplass[10];

    Bil bil1 = new Bil(17, 170);
    Bil bil2 = new Bil(19, 190);
    Bil bil3 = new Bil(20, 200);
    Motorsykkel motorsykkel1 = new Motorsykkel(17, 170);
    Motorsykkel motorsykkel2 = new Motorsykkel(19, 190);
    Motorsykkel motorsykkel3 = new Motorsykkel(20, 200);

    Parkeringsplass<Bil> forsteEtasje = new Parkeringsplass<Bil>();
    Parkeringsplass<Motorsykkel> andreEtasje = new
    Parkeringsplass<Motorsykkel>();

    forsteEtasje.settInn(bil1);
    forsteEtasje.settInn(bil2);
    andreEtasje.settInn(motorsykkel1);
    andreEtasje.settInn(motorsykkel2);

    andreEtasje.taUt();

    etasje1[1] = forsteEtasje;
    etasje1[2] = andreEtasje;
  }

}

class Person{

String navn;
String tekst;
Person neste;

  public Person(String navn, String tekst){
    this.navn = navn;
    this.tekst = tekst;
  }

  public void settPerson(Person p){
    this.neste = p;
  }

  public Person hentPerson(){
    return this.neste;
  }

}

class Butikk{

Person forste;

  public void entreButikk(Person p){
    if (this.forste == null) this.forste = p;
    else{
      Person temp = forste;
      while (temp.neste != null){
        temp = temp.neste;
      }
      temp.neste = p;
    }
  }

  public void kassa(){
    while (this.forste != null){
      System.out.println(this.forste.navn + " kjøper en " + this.forste.tekst +
      ".");
      this.forste = this.forste.neste;
    }
  }

}

class TestProgram3{

  public static void main(String[] args){
    Person p1 = new Person("Mehdi", "3DS");
    Person p2 = new Person("M", "GBA");
    Person p3 = new Person("e", "DS");
    Person p4 = new Person("h", "DSi");
    Person p5 = new Person("69", "DSi XL");
    Butikk butikk1 = new Butikk();

    butikk1.entreButikk(p1);
    butikk1.entreButikk(p2);
    butikk1.entreButikk(p3);
    butikk1.entreButikk(p4);
    butikk1.entreButikk(p5);
    butikk1.kassa();
  }

}

class KvadratStabel{

Node forste;

  class Node{

  Node neste;
  Kvadrat data;

    Node(Kvadrat data){
      this.data = data;
    }

  }

  public void leggPaa(Kvadrat k){
    Node nyNode = new Node(k);
    if (this.erTom() == true) this.forste = nyNode;
    else{
      Node tmp = this.forste;
      nyNode.neste = tmp;
      this.forste = nyNode;
    }
  }

  public Kvadrat taAv(){
    if (this.erTom() == true) return null;
    else if (forste.neste == null){
      Node tmp = this.forste;
      this.forste = null;
      return tmp.data;
    } else{
      Node tmp = this.forste;
      this.forste = this.forste.neste;
      return tmp.data;
    }
  }

  public boolean erTom(){
    if (this.forste == null) return true;
    else return false;
  }

}

class TestKvadratStabel {
    public static void main(String[] args) {
        KvadratStabel stabel = new KvadratStabel();
        stabel.leggPaa(new Kvadrat(1));
        stabel.leggPaa(new Kvadrat(2));
        stabel.leggPaa(new Kvadrat(3));
        stabel.leggPaa(new Kvadrat(4));
        stabel.leggPaa(new Kvadrat(5));
        stabel.leggPaa(new Kvadrat(6));
        double sum = 0, siste = 0;
        while (!stabel.erTom()){
            Kvadrat k = stabel.taAv();
            sum += k.areal();
            siste = k.areal();
        }
        System.out.println("Summen av kvadratenes areal er "
                           + sum);
        System.out.println("Det siste kvadratet i stabelen har areal: "
                           + siste);
    }
}

class GeneriskStabel<T>{

Node forste;

  class Node{

  Node neste;
  T data;

    Node(T data){
      this.data = data;
    }

  }

  public void leggPaa(T k){
    Node nyNode = new Node(k);
    if (this.erTom() == true) this.forste = nyNode;
    else{
      Node tmp = this.forste;
      nyNode.neste = tmp;
      this.forste = nyNode;
    }
  }

  public T taAv(){
    if (this.erTom() == true) return null;
    else if (forste.neste == null){
      Node tmp = this.forste;
      this.forste = null;
      return tmp.data;
    } else{
      Node tmp = this.forste;
      this.forste = this.forste.neste;
      return tmp.data;
    }
  }

  public boolean erTom(){
    if (this.forste == null) return true;
    else return false;
  }

}

class TestGeneriskStabel {
    public static void main(String[] args) {
        GeneriskStabel<String> stabel = new GeneriskStabel<String>();
        stabel.leggPaa("foobar");
        stabel.leggPaa("bazar");
        stabel.leggPaa("baz");
        stabel.leggPaa("bar");
        stabel.leggPaa("Foo");
        String resultat = "";
        while (!stabel.erTom())
            resultat += stabel.taAv() + " ";
        System.out.printf("Resultatet er: '%s'\n", resultat);
    }
}
