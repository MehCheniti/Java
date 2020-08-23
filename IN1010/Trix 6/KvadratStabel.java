class KvadratStabel{

Node start;
Node slutt;
int teller = 0;

  public KvadratStabel(){
    start = new Node(null);
    slutt = new Node(null);
    start.neste = slutt;
    slutt.forrige = start;
  }

  public void leggPaa(Kvadrat x){
    Node nyNode = new Node(x);

    if (teller == 0){
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

  public Kvadrat taAv(){
    if (teller == 1){
      Node fjernet = start.neste;
      start.neste = slutt;
      slutt.forrige = start;
      teller--;
      return fjernet.data;
    } else{
      Node fjernet = slutt.forrige;
      fjernet.neste = slutt;
      slutt.forrige = fjernet.forrige;
      fjernet.forrige.neste = slutt;
      teller--;
      return fjernet.data;
    }
  }

  public boolean erTom(){
    if (teller == 0){
      return true;
    }

    return false;
  }

  class Node{

  Node neste;
  Node forrige;
  Kvadrat data;

    Node(Kvadrat data){
      this.data = data;
      }

  }

}

class TestKvadratStabel{

  public static void main(String[] args){
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

    System.out.println("Summen av kvadratenes areal er " + sum + ".");
    System.out.println("Det siste kvadratet i stabelen har areal: " + siste +
    ".");
  }

}
