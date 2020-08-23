class Node {
    Node neste; // = null hvis ingen neste
    String verdi;

    public Node(String verdi) {
        this.verdi = verdi;
    }

    public void settNeste(Node n) {
        neste = n;
    }

    public Node hentNeste() {
        return neste;
    }

    public String hentData() {
        return verdi;
    }
}
