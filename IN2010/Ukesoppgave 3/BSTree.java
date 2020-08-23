public class BSTree{

int antNoder = 0;
Node root = null;

private class Node{

Node left, right; // verdier i venstre subtre er < verdien i noden selv
// verdier i høyre subtre er > verdien i noden selv
Node parent;
int value; // konstruktører, programmer disse

  Node(int v){
    value = v;
  }

}

  private Node findParent(Node n){
    return n.parent;
  }

  private Node findGrandparent(Node n){
    if (n.parent == null){
      return null;
    }

    return n.parent.parent;
  }

  private Node find(int value){
    return findRec(root, value);
  }

  private Node findRec(Node current, int value){
    if (current == null){
      return null;
    }

    if (current.value < value){
      return findRec(current.right,value);
    } else if (current.value > value){
      return findRec(current.left,value);
    }

    return current;
  }

}
