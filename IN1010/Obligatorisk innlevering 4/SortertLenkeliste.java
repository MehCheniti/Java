class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

  @Override public void leggTil(T x){
    Node nyNode = new Node(x);

    if (stoerrelse() == 0){
      start.neste = nyNode;
      nyNode.forrige = start;
      nyNode.neste = slutt;
      slutt.forrige = nyNode;
      teller++;
    } else{
      if (start.neste.data.compareTo(nyNode.data) >= 0){
        nyNode.forrige = start;
        nyNode.neste = start.neste;
        nyNode.neste.forrige = nyNode;
        start.neste = nyNode;
        teller++;
      } else if (slutt.forrige.data.compareTo(nyNode.data) < 0){
        nyNode.forrige = slutt.forrige;
        slutt.forrige.neste = nyNode;
        slutt.forrige = nyNode;
        nyNode.neste = slutt;
        teller++;
      } else{
        Node peker = start.neste;
        int counter = 0;
        while (peker.data.compareTo(nyNode.data) <= 0){
          peker = peker.neste;
          counter++;
        }
        Node tmp = peker.forrige;
        tmp.neste = nyNode;
        nyNode.forrige = peker.forrige;
        nyNode.neste = peker;
        peker.forrige = nyNode;
        teller++;
      }
    }
  }

  @Override public T fjern(){
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
      slutt.forrige.forrige.neste = slutt;
      slutt.forrige = fjernet.forrige;
      teller--;
      return fjernet.data;
    }
  }

  @Override public void sett(int pos, T x){
    throw new UnsupportedOperationException();
  }

  @Override public void leggTil(int pos, T x){
    throw new UnsupportedOperationException();
  }

}
