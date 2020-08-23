import java.util.*;

class Node {
	private int label;
	private boolean visited = false;
	private List<Node> neighbors = new LinkedList<Node>();

	public Node(int label) {
		this.label = label;
	}

	public int getLabel() {
		return label;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public boolean isVisited() {
		return visited;
	}

	public void visit() {
		visited = true;
	}

	public void notVisit() {
		visited = false;
	}

	public void addNeighbor(Node n) {
		// legger til en uretta kant fra this til n
		if (!neighbors.contains(n)) {
			neighbors.add(n);
			n.addNeighbor(this);
		}
	}

	public void addSuccessor(Node n) {
		// legger til en retta kant fra this til n
		if (!neighbors.contains(n)) {
			neighbors.add(n);
		}
	}

	public String toString() {
		return Integer.toString(label);
	}
}

class Graph {
	private Node[] nodes;

	public Graph(Node[] nodes) {
		this.nodes = nodes;
	}

	public void printNeighbors() {
		for (Node n1 : nodes) {
			String s = n1.toString() + ": ";
			for (Node n2 : n1.getNeighbors()) {
				s += n2.toString() + " ";
			}
			System.out.println(s.substring(0, s.length() - 1));
		}
	}

	private static Graph buildExampleGraph() {
	    // ukeoppgave
		Node[] nodes = new Node[7];
		for (int i = 0; i < 7; i++) {
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

	private static Graph buildRandomSparseGraph(int numberofV, long seed) {
		// seed brukes av java.util.Random for å generere samme sekvens for samme frø
		// (seed) og numberofV
		java.util.Random tilf = new java.util.Random(seed);
		int tilfeldig1 = 0, tilfeldig2 = 0;
		Node[] nodes = new Node[numberofV];

		for (int i = 0; i < numberofV; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < numberofV; i++) {
			tilfeldig1 = tilf.nextInt(numberofV);
			tilfeldig2 = tilf.nextInt(numberofV);
			if (tilfeldig1 != tilfeldig2)
				nodes[tilfeldig1].addNeighbor(nodes[tilfeldig2]);
		}
		return new Graph(nodes);
	}

	private static Graph buildRandomDenseGraph(int numberofV, long seed) {
		java.util.Random tilf = new java.util.Random(seed);
		int tilfeldig1 = 0, tilfeldig2 = 0;
		Node[] nodes = new Node[numberofV];

		for (int i = 0; i < numberofV; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < numberofV * numberofV; i++) {
			tilfeldig1 = tilf.nextInt(numberofV);
			tilfeldig2 = tilf.nextInt(numberofV);
			if (tilfeldig1 != tilfeldig2)
				nodes[tilfeldig1].addNeighbor(nodes[tilfeldig2]);
		}
		return new Graph(nodes);
	}

	private static Graph buildRandomDirGraph(int numberofV, long seed) {
		java.util.Random tilf = new java.util.Random(seed);
		int tilfeldig1 = 0, tilfeldig2 = 0;
		Node[] nodes = new Node[numberofV];

		for (int i = 0; i < numberofV; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < 2 * numberofV; i++) {
			tilfeldig1 = tilf.nextInt(numberofV);
			tilfeldig2 = tilf.nextInt(numberofV);
			if (tilfeldig1 != tilfeldig2)
				nodes[tilfeldig1].addSuccessor(nodes[tilfeldig2]);
		}
		return new Graph(nodes);
	}

	public void DFS(Node s) {
    s.visit();

    for (Node n : s.getNeighbors()){
      if (n.isVisited() == false){
        this.DFS(n);
      }
    }
	}

	public void DFSFull() {
		for (Node n : nodes){
      if (n.isVisited() == false){
        this.DFS(n);
      }
    }
	}

        public int numberOfComponents() {
			for (Node n : nodes){
				n.notVisit();
			}

      int counter = 0;

	    for (Node n : nodes){
				if (n.isVisited() == false){
					this.DFS(n);
					counter++;
				}
      }

      return counter;
	}

        public Graph transformDirToUndir() {
			Node[] nodesClone = this.nodes.clone();
			List<Node> newNeighbors = new LinkedList<Node>();

			for (Node nc : nodesClone){
				newNeighbors = nc.getNeighbors();
				for (Node nn : newNeighbors){
					nn.addNeighbor(nc);
				}
			}

			return new Graph(nodesClone);
	}

        public boolean isConnected(){
			this.transformDirToUndir();

			if (this.numberOfComponents() > 1){
				return true;
			} else{
				return false;
			}
	}

        public Graph biggestComponent() {
			Node[] newNodes;
			LinkedList<Node> nodes1 = new LinkedList<>();

			for (Node n : nodes){
				if (n.isVisited() == false){
					LinkedList<Node> nodes2 = nodes3(n, new LinkedList<>());
					if (nodes1.size() < nodes2.size()){
						nodes1 = nodes2;
					}
				}
			}

			newNodes = nodes1.toArray(new Node[nodes1.size()]);
			return new Graph(newNodes);
	}

	private LinkedList<Node> nodes3(Node n, LinkedList<Node> newList){
		n.visit();
		newList.add(n);

		for (Node n2 : n.getNeighbors()){
			if (n.isVisited() == false){
				nodes3(n, newList);
			}
		}

		return newList;
	}

	public int[][] buildAdjacencyMatrix() {
		int[][] adjacencyMatrix = new int[nodes.length][nodes.length];

		for (Node n : nodes){
			for (Node n2 : n.getNeighbors()){
				adjacencyMatrix[n.getLabel()][n2.getLabel()] = 1;
			}
		}

		return adjacencyMatrix;
	}

	public static void main(String[] args) {
		Graph graph = buildExampleGraph();
		graph = buildRandomSparseGraph(11, 201909202359L);
		graph.printNeighbors();
		System.out.println("");
		graph = buildRandomDenseGraph(15, 201909202359L);
		graph.printNeighbors();

		System.out.println("");
		System.out.println("* TEST *");
		System.out.println("Oppgave 1: ");
		System.out.println("# of components: " + graph.numberOfComponents() + ".");
		System.out.println("Oppgave 2: ");
		Graph graph2 = buildRandomDirGraph(17, 201909202359L);
		graph2.printNeighbors();
		System.out.println(graph2.isConnected());
		graph2.transformDirToUndir();
		graph2.printNeighbors();
		System.out.println(graph2.isConnected());
		System.out.println("Oppgave 3: ");
		System.out.println(graph.isConnected());
		System.out.println("Oppgave 4: ");
		graph.biggestComponent().printNeighbors();
		System.out.println("Oppgave 5: ");
		System.out.println(graph.buildAdjacencyMatrix());
		System.out.println("* TEST SLUTT *");
	}
}

// Oppgave 1X
// Nei den er ikke sammenhengende, fordi den inneholder 2 komponenter.

// Oppgave 1F
// En stjerne med |V| noder vil da ha |V| - 1 kanter, siden det alltid er én
// node i midten.

// Oppgave 1G
// Vi kan representere stjerneskogen med en array hvor hvert element i arrayen
// representerer antall noder i stjernen.
