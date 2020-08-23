class MotorsykkelProgram{

  public static void main(String[] args){
    Motorsykkel motorsykkel = new Motorsykkel("1720");
    int teller = 5;
    while (teller > 0){
      motorsykkel.kjoer(10);
      teller -= 1;
    }

    System.out.println(motorsykkel.hentKilometerstand());

    Motorsykkel motorsykkel2 = new Motorsykkel("17201");
    Motorsykkel motorsykkel3 = new Motorsykkel("17209");
    System.out.println(motorsykkel2.hentProduksjonsnummer());
    System.out.println(motorsykkel3.hentProduksjonsnummer());
  }

}
