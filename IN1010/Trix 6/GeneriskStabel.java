class GeneriskStabel<T>{

Node start;
Node slutt;
int teller = 0;

  public GeneriskStabel(){
    start = new Node(null);
    slutt = new Node(null);
    start.neste = slutt;
    slutt.forrige = start;
  }

  public void leggPaa(T x){
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

  public T taAv(){
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
  T data;

    Node(T data){
      this.data = data;
      }

  }

}

class TestGeneriskStabel{

  public static void main(String[] args){
    GeneriskStabel<String> stabel = new GeneriskStabel<String>();

    stabel.leggPaa("foobar");
    stabel.leggPaa("bazar");
    stabel.leggPaa("baz");
    stabel.leggPaa("bar");
    stabel.leggPaa("Foo");

    String resultat = "";

    while (!stabel.erTom()){
      resultat += stabel.taAv() + " ";
    }

    System.out.printf("Resultatet er: '%s'\n", resultat);
  }

}
