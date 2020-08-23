class Bil3{

  String bilnummer;

  Bil3(String bilnummer){
    this.bilnummer = bilnummer;
  }

  void skrivUt(){
    System.out.println("Jeg er en bil");
    System.out.print("Bilnummeret er: " + bilnummer + ".");
  }

  String hentNummer(){
    return bilnummer;
  }

}
