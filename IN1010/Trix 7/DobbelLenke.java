public class DobbelLenke<T>{

Node start;
Node slutt;

  public DobbelLenke(){
    start = new Node(null);
    slutt = new Node(null);
    start.neste = slutt;
    slutt.forrige = start;
  }

  public void leggTil(T x){
    Node nyNode = new Node(x);
    if (start.neste == null){
      start.neste = nyNode;
      nyNode.forrige = start;
      nyNode.neste = slutt;
      slutt.forrige = nyNode;
    } else{
      slutt.forrige.neste = nyNode;
      nyNode.neste = slutt;
      nyNode.forrige = slutt.forrige;
      slutt.forrige = nyNode;
    }
  }

class Node{

Node neste;
Node forrige;
T data;

  public Node(T data){
    this.data = data;
  }

}

}
