import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String>{

private String[] arr;
private int maksStorrelse;
private int storrelse = 0;

  public EnkelArrayListe(int maksStorrelse){
    this.maksStorrelse = maksStorrelse;
    arr = new String[maksStorrelse];
  }

  public void leggTil(String x){
    if (storrelse >= maksStorrelse){
      throw new IllegalStateException("Ikke plass til flere.");
    }
    arr[storrelse++] = x;
  }

  public Iterator<String> iterator() {
    return new ListeIterator();
  }

private class ListeIterator implements Iterator<String> {

private int gjeldendeIndeks = 0;

  public String next() {
    return arr[gjeldendeIndeks++];
  }

  public boolean hasNext() {
    return gjeldendeIndeks < storrelse;
  }

}

}
