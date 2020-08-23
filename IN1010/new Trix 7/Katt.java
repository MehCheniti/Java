import java.util.ArrayList;
import java.util.Iterator;

class Katt implements Comparable<Katt>{

String navn;
int alder;

  public Katt(String navn, int alder){
    this.navn = navn;
    this.alder = alder;
  }

  @Override public String toString(){
    return "Navn: " + navn + ". Alder: " + alder + ".";
  }

  public int compareTo(Katt k){
    if (k.alder > alder) return -1;
    if (k.alder < alder) return 1;
    if (k.alder == alder) return 0;
    return 17;
  }

}

class TestProgram{

  public static void main(String[] args){
    ArrayList<Katt> liste = new ArrayList<>();
    Katt k1 = new Katt("Mehdi", 17);
    Katt k2 = new Katt("Cheniti", 20);

    liste.add(k1);
    liste.add(k2);

    Katt eldste = liste.get(0);

    for (Katt k : liste){
      if (k.compareTo(eldste) == 1) eldste = k;
    }

    System.out.println(eldste.toString());
  }

}

class Beholder<T extends Comparable<T>>{

T element;

  public T settInn(T e){
    if (element == null){
      element = e;
      return null;
    } else{
      if (e.compareTo(element) >= 0){
        T temp = element;
        element = e;
        return temp;
      }
      if (e.compareTo(element) <= 0) return null;
      return null;
    }
  }

  public T getElement(){
    return element;
  }

}

class TestProgram2{

  public static void main(String[] args){
    Beholder<Katt> beholder = new Beholder<Katt>();
    Katt k1 = new Katt("Mehdi", 17);
    Katt k2 = new Katt("Cheniti", 19);
    Katt k3 = new Katt("MC", 20);
    beholder.settInn(k1);
    System.out.println(beholder.getElement());
    beholder.settInn(k3);
    System.out.println(beholder.getElement());
    beholder.settInn(k2);
    System.out.println(beholder.getElement());
  }

}

class DobbelLenke<T>{

Node forste;

  class Node{

  Node neste;
  Node forrige;
  T data;

    public Node(T data){
      this.data = data;
    }

  }

  public void settInn(T element){
    Node nyNode = new Node(element);

    if (forste == null){
      forste = nyNode;
    } else{
      Node peker = forste.neste;
      while (peker != null){
        peker = peker.neste;
      }
      peker.forrige.neste = nyNode;
      nyNode.neste = peker;
      nyNode.forrige = peker.forrige;
      peker.forrige = nyNode;
    }
  }

}

class EnkelArrayListe{

String[] array;
int kapasitet;

  public EnkelArrayListe(int kapasitet){
    this.kapasitet = kapasitet;
    String[] array = new String[kapasitet];
  }

  public void settInn(String str){
    int counter = 0;
    boolean sattInn = false;

    while (counter < array.length && sattInn == false){
      if (array[counter] == null){
        array[counter] = str;
        sattInn = true;
      }
      counter++;
    }
  }

  public Iterator<String> iterator(){
    return new ArrayListIterator();
  }

  class ArrayListIterator implements Iterator<String>{

  private int indeks = 0;

    public boolean hasNext(){
      return indeks < kapasitet;
    }

    public String next(){
      return array[indeks++];
    }

  }

}

class SortertArrayList<T extends Comparable<T>>{

ArrayList<T> liste = new ArrayList<T>();

  public void settInn(T element){
    for (int i = 0; i < liste.size(); i++){
      if (liste.get(i).compareTo(element) > 0){
        liste.add(i, element);
        return;
      }
    }

    liste.add(element);
  }

  public T hentUtForste(){
    T tmp = liste.get(0);
    liste.remove(0);
    return tmp;
  }

}

class TestProgram3{

  public static void main(String[] args){
    SortertArrayList<Katt> beholder = new SortertArrayList<Katt>();
    Katt k1 = new Katt("Mehdi", 17);
    Katt k2 = new Katt("Cheniti", 19);
    Katt k3 = new Katt("MC", 20);
    Katt k4 = new Katt("M", 99);
    beholder.settInn(k1);
    beholder.settInn(k2);
    beholder.settInn(k3);
    beholder.settInn(k4);
    System.out.println(beholder.hentUtForste());
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

  public void settNeste(Person p){
    this.neste = p;
  }

  public Person hentNeste(){
    return this.neste;
  }

}

class Butikk implements Iterable<Person>{
    private Person foerste;

    public void settInn(Person p) {
        if (this.foerste == null) {
            this.foerste = p;
        } else {
            Person midlertidig = foerste;
            while (midlertidig.hentNeste() != null) {
                midlertidig = midlertidig.hentNeste();
            }
            midlertidig.settNeste(p);
        }
    }

    public Iterator<Person> iterator(){
      return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person>{
      private Person denne;

      public PersonIterator(){
        denne = foerste;
      }

      @Override
      public boolean hasNext(){
        return denne != null;
      }

      @Override
      public Person next(){
        Person midl = denne;
        denne = denne.hentNeste();
        return midl;
      }
    }
}

class TestButikk {
    public static void main(String[] args) {
        Butikk butikken = new Butikk();

        butikken.settInn(new Person("Stig", "Sitronsaft"));
        butikken.settInn(new Person("Hedda", "Engangskopper"));
        butikken.settInn(new Person("Jawad", "Pasta"));
        butikken.settInn(new Person("Henrik", "Kaffe"));
        butikken.settInn(new Person("Mathias", "Tomatsuppe"));

        System.out.println("BUTIKK-KØ: ");
        for(Person p : butikken){
          System.out.println(p);
        }
    }
}
