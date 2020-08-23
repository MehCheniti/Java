import java.util.NoSuchElementException;
import java.util.Iterator;

public class  Kennel<T extends Husdyr> implements Iterable<T>{

private Bur foran;

  public Kennel(){
    foran = new Bur(null);
  }

  private class Bur{

  T dyr;
  Bur neste;

    public Bur(T data){
      dyr = data;
    }

  }

  public void sjekkInn(T dyr){
    Bur ny = new Bur(dyr);
    Bur pos = foran;
    while (pos.neste != null){
      pos = pos.neste;
    }
    pos.neste = ny;
  }

  public boolean taUt(int id){
      Bur pos = foran;
      while (pos.neste != null){
        if (pos.neste.dyr.hentId() == id){
          pos.neste = pos.neste.neste;
          return true;
        }
        pos = pos.neste;
      }
      return false;
  }

  public void skrivAlle(){
    for (T dyr : this){
      System.out.println(dyr);
    }
  }

  public Iterator<T> iterator(){
    return new KennelIterator();
  }

  private class KennelIterator implements Iterator<T>{

  private Bur posisjon;

    public KennelIterator(){
      posisjon = foran;
    }

    @Override public boolean hasNext(){
      return posisjon.neste != null;
    }

    @Override public T next(){
      if (!hasNext()){
        throw new NoSuchElementException();
      }
      posisjon = posisjon.neste;
      return posisjon.dyr;
    }

    @Override public void remove(){
      throw new UnsupportedOperationException();
    }

  }

}
