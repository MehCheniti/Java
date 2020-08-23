public class OrdnetPar<K, V> implements Par<K, V>{

K nokkel;
V verdi;

  public OrdnetPar(K n, V v){
    nokkel = n;
    verdi = v;
  }

  @Override public K hentNokkel(){
    return nokkel;
  }

  @Override public V hentVerdi(){
    return verdi;
  }

}
