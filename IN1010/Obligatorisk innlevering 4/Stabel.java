class Stabel<T> extends Lenkeliste<T>{

  public void leggPaa(T x){
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

  public T taAv(){
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
      Node fjernet = slutt.forrige;
      fjernet.neste = slutt;
      slutt.forrige = fjernet.forrige;
      fjernet.forrige.neste = slutt;
      teller--;
      return fjernet.data;
    }
  }

}
