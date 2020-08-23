class LenkeListe{

Node start;

  public class Node{

  public Node neste;
  String element;

    Node(String s){
      element = s;
    }
  }

  public LenkeListe(){
    start = new Node("Start Node");
  }

  public void settInn(String elem){
    Node nyNode = new Node(elem);
    Node node = start;
    while (node.neste != null){
      node = node.neste;
    }
    node.neste = nyNode;
  }

  public boolean finn(String elem){
    Node node = start;
    while(node.neste != null){
      node = node.neste;
      if (node.data.equals(elem)){
        return true;
      }
    }
    return false;
  }

  // Returnerer -1 om den ikke finnes.
  public int finnIndeks(String elem){
    Node node = start;
    int teller = -1;
    while(node.neste != null){
      node = node.neste;
      teller++;
      if (node.element.equals(elem)){
        return teller;
      }
    }
    return teller;
  }

  public boolean fjern(String elem){
    Node nyNode = new Node(elem);
    Node node = start;
    while (node.neste != null){
      if (node.neste.element.equals(elem)){
        node.neste = node.neste.neste;
        return true;
      }
      node = node.neste;
    }
    node.neste = nyNode;
    return false;
  }

  public void settInnPaa(int i, String elem){
    Node nyNode = new Node(elem);
    Node node = start;
    int teller = -1;
    while (node.neste != null){
      if (teller + 1 == i){
        Node tmp = node.neste;
        node.neste = nyNode;
        nyNode.neste = tmp;
        return;
      }
      teller++;
      node = node.neste;
      return;
    }
  }

}
