import java.util.List;
import java.util.LinkedList;

class Node{

private int label;
private boolean visited = false;
private List<Node> neighbors = new LinkedList<Node>();

  public Node(int label){
    this.label = label;
  }

  public int getLabel(){
    return label;
  }

  public List<Node> getNeighbors(){
    return neighbors;
  }

  public boolean isVisited(){
    return visited;
  }

  public void visit(){
    visited = true;
  }

  public void addNeighbor(Node n){
    if (!neighbors.contains(n)){
      neighbors.add(n);
      n.addNeighbor(this);
    }
  }

  public String toString(){
    return Integer.toString(label);
  }

}

class Graph{

private Node[] nodes;

  public Graph(Node[] nodes){
    this.nodes = nodes;
  }

  public void printNeighbors(){
    for (Node n1 : nodes){
      String s = n1.toString() + ": ";
      for (Node n2 : n1.getNeighbors()){
        s += n2.toString() + " ";
      }
      System.out.println(s.substring(0, s.length() - 1));
    }
  }

  private static Graph buildExampleGraph(){
    Node[] nodes = new Node[7];

    for (int i = 0; i < 7; i++){
      nodes[i] = new Node(i);
    }

    nodes[0].addNeighbor(nodes[1]);
    nodes[0].addNeighbor(nodes[2]);
    nodes[1].addNeighbor(nodes[2]);
    nodes[2].addNeighbor(nodes[3]);
    nodes[2].addNeighbor(nodes[5]);
    nodes[3].addNeighbor(nodes[4]);
    nodes[4].addNeighbor(nodes[5]);
    nodes[5].addNeighbor(nodes[6]);
    return new Graph(nodes);
  }

  public void DFS(Node s){
    System.out.println(s);
    s.visit();
    for (Node n : s.getNeighbors()){
      if (n.isVisited() == false){
        DFS(n);
      }
    }
  }

  public void DFSFull(){
    for (Node n : nodes){
      if (n.isVisited() == false){
        DFS(n);
      }
    }
  }

  public static void main(String[] args){
    Graph graph = buildExampleGraph();
    graph.printNeighbors();
    graph.DFSFull();
  }

}
