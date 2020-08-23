public class Hovedprogram{

  public static void main(String[] args){
    Parkeringsplass<Bil> biler = new Parkeringsplass<Bil>(1);
    Parkeringsplass<Motorsykkel> motorsykler = new
    Parkeringsplass<Motorsykkel>(1);

    Bil bil = new Bil(171717, 5);
    Motorsykkel motorsykkel = new Motorsykkel(343434, 17);

    biler.settInn(bil);
    motorsykler.settInn(motorsykkel);
  }

}
