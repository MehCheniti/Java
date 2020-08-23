public class Hovedprogram{

  public static void main(String[] args){
    GeneriskBeholder<Husdyr> beholder = new GeneriskBeholder<Husdyr>(5);
    Hund gizmo = new Hund("Gizmo", 9);

    if (beholder.settInn(gizmo)){
      System.out.println("Gizmo ble satt inn.");
    }

    Katt hufse = new Katt("Hufse", 2);
    beholder.settInn(hufse);
    Hund yoda = new Hund("Yoda", 6000);
    beholder.settInn(yoda);
    beholder.fjern(1);
    if (!beholder.settInn(gizmo)){
      System.out.println("Enten fullt, eller så er Gizmo her fra før.");
    }
    beholder.skrivAlle();

    GeneriskBeholder<Integer> intBeholder = new GeneriskBeholder<Integer>(5);
    intBeholder.settInn(42);
    intBeholder.settInn(4);
    intBeholder.settInn(7);
    intBeholder.settInn(33821);
    intBeholder.skrivAlle();
    System.out.println(intBeholder.fjern(4));
    intBeholder.skrivAlle();

    // GeneriskBeholder<String> beholder = new GeneriskBeholder<String>(6);
    //
    // beholder.skrivAlle();
    //
    // if (!beholder.settInn("Hei.")){
    //   System.out.println("Vi fikk ikke satt inn!");
    // } else {
    //   System.out.println("Vi fikk det til!");
    // }
    //
    // beholder.skrivAlle();
    // beholder.skrivUtenNull();
    // System.out.println();
    // beholder.settInn("Hallo.");
    // beholder.fjern("Hei.");
    // beholder.skrivAlle();
    // System.out.println(beholder.fjern(-100));
  }

}
