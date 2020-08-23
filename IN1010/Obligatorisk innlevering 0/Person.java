class Person{

  Bil3 bil;

  Person(Bil3 bil){
    this.bil = bil;
  }

  void skrivUt(){
    System.out.print("Bilnummeret er: " + bil.hentNummer() + ".");
  }

}
