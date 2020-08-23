public class Parkeringshus{

  public static void main(String[] args){
    Parkeringsplass<Bil> etasje1 = new Parkeringsplass<Bil>(10);
    Parkeringsplass<Motorsykkel> etasje2 = new Parkeringsplass<Motorsykkel>(10);

    Bil bil1 = new Bil(17, 5);
    Bil bil2 = new Bil(18, 2);
    Bil bil3 = new Bil(19, 5);

    Motorsykkel motorsykkel1 = new Motorsykkel(20, 34);
    Motorsykkel motorsykkel2 = new Motorsykkel(21, 35);
    Motorsykkel motorsykkel3 = new Motorsykkel(22, 36);

    etasje1.settInn(bil1);
    etasje1.settInn(bil2);
    etasje2.settInn(motorsykkel1);
    etasje2.settInn(motorsykkel2);

    etasje2.fjern(motorsykkel1);
    etasje2.fjern(motorsykkel2);
  }

}
