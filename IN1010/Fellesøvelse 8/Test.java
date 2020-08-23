public class Test{

  public static void main(String[] args){
    Kvadrat kvadrat = new Kvadrat(10);
    testLikhet(100.0, kvadrat.hentAreal(), kvadrat);
    testLikhet("Kvadrat (lengde: 10.0)", kvadrat.toString(), kvadrat);

    Hund hund = new Hund("Fido", 3);
    testLikhet(21, hund.hentAlder(), hund);

    Sirkel s1 = new Sirkel(10);
    testLikhet(314, (int) Math.round(s1.hentAreal()), s1);
    Sirkel s2 = new Sirkel(11);
    testLikhet(380.1, (double) Math.round(s2.hentAreal() * 10) / 10, s2);
  }

  static void testLikhet(Object forventet, Object faktisk, Object obj){
    if (forventet.equals(faktisk)){
      System.out.println("Test ok.");
    } else{
      System.out.println("FEIL - forventet: " + forventet + ", faktisk: " +
      faktisk + ", feil paa objekt: " + obj + ".");
    }
  }

}
