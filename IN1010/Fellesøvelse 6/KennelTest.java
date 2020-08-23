public class KennelTest{

  public static void main(String[] args){
    Kennel<Husdyr> kennel = new Kennel<Husdyr>();

    Hund hund = new Hund("Doge", 5);
    Katt katt = new Katt("Snofot", 12);
    Hund hund2 = new Hund("Manell", 5);

    kennel.skrivAlle();

    kennel.sjekkInn(hund);
    kennel.sjekkInn(katt);
    kennel.sjekkInn(hund2);

    kennel.skrivAlle();

    // Iterator<Husdyr> it = kennel.iterator();
    // while (it.hasNext()){
    //   System.out.println(it.next());
    // }

    System.out.println(kennel.taUt(1));
    System.out.println(kennel.taUt(123));
    kennel.skrivAlle();
  }

}
