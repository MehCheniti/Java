import java.util.Iterator;

class Lenkeliste<T> implements Liste<T>{

Node start;
Node slutt;
int teller = 0;

  public Lenkeliste(){
    start = new Node(null);
    slutt = new Node(null);
    start.neste = slutt;
    slutt.forrige = start;
  }

  public int stoerrelse(){
    return teller;
  }

  public void leggTil(int pos, T x){
    if (pos < 0 || pos > teller){
      throw new UgyldigListeIndeks(pos);
    }
    Node nyNode = new Node(x);
    if (stoerrelse() == 0){
      leggTil(nyNode.data);
    }
    else{
      Node peker = start.neste;
      int counter = 0;
      while (counter < pos){
        peker = peker.neste;
        counter++;
      }
      peker.forrige.neste = nyNode;
      nyNode.neste = peker;
      nyNode.forrige = peker.forrige;
      peker.forrige = nyNode;
      teller++;
    }
  }

  public void leggTil(T x){
    Node nyNode = new Node(x);
    if (stoerrelse() == 0){
      start.neste = nyNode;
      nyNode.forrige = start;
      nyNode.neste = slutt;
      slutt.forrige = nyNode;
      teller++;
    } else{
      slutt.forrige.neste = nyNode;
      nyNode.neste = slutt;
      nyNode.forrige = slutt.forrige;
      slutt.forrige = nyNode;
      teller++;
    }
  }

  public void sett(int pos, T x){
    if (pos < 0 || pos >= teller){
      throw new UgyldigListeIndeks(pos);
    }
    Node nyNode = new Node(x);
    if (stoerrelse() == 0){
      leggTil(nyNode.data);
    }
    else{
      Node peker = start.neste;
      int counter = 0;
      while (counter < pos){
        peker = peker.neste;
        counter++;
      }
      peker.data = nyNode.data;
    }
  }

  public T hent(int pos){
    if (pos < 0 || pos >= teller){
      throw new UgyldigListeIndeks(pos);
    } else{
      Node element = start.neste;
      int counter = 0;
      while (counter < pos){
        element = element.neste;
        counter++;
      }
      return element.data;
    }
  }

  public T fjern(int pos){
    if (pos < 0 || pos >= teller){
      throw new UgyldigListeIndeks(pos);
    }
    if (stoerrelse() == 0){
      throw new UgyldigListeIndeks(-1);
    }
    if (stoerrelse() == 1){
      Node fjernet = start.neste;
      start.neste = slutt;
      slutt.forrige = start;
      teller--;
      return fjernet.data;
    } else{
      Node fjernet = start.neste;
      int counter = 0;
      while (counter < pos){
        fjernet = fjernet.neste;
        counter++;
      }
      fjernet.forrige.neste = fjernet.neste;
      fjernet.neste.forrige = fjernet.forrige;
      teller--;
      return fjernet.data;
    }
  }

  public T fjern(){
    if (stoerrelse() == 0){
      throw new UgyldigListeIndeks(-1);
    }
    if (stoerrelse() == 1){
      Node fjernet = start.neste;
      start.neste = slutt;
      slutt.forrige = start;
      teller--;
      return fjernet.data;
    } else{
      Node fjernet = start.neste;
      start.neste = fjernet.neste;
      fjernet.neste.forrige = start;
      teller--;
      return fjernet.data;
    }
  }

  public Iterator<T> iterator(){
    return new LenkelisteIterator();
  }

  class Node{

  Node neste;
  Node forrige;
  T data;

    Node(T data){
      this.data = data;
      }

  }

  class LenkelisteIterator implements Iterator<T>{

  private int indeks = 0;

    public boolean hasNext(){
      return indeks < stoerrelse();
    }

    public T next(){
      return hent(indeks++);
    }

  }

}
