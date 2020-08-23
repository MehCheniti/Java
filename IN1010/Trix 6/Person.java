class Person{

private String navn;
private String gjenstand;
private Person neste;

  public Person(String navn, String gjenstand){
    this.navn = navn;
    this.gjenstand = gjenstand;
  }

  public void settNeste(Person p){
    neste = p;
  }

  public Person hentNeste(){
    return this.neste;
  }

  public String toString(){
    return navn + " med gjenstand " + gjenstand + ".";
  }

}

class Butikk{

private Person forste;

  public void entreButikk(Person p){
    if (this.forste == null){
      this.forste = p;
    } else{
      Person midlertidig = forste;
      while (midlertidig.hentNeste() != null){
        midlertidig = midlertidig.hentNeste();
      }

      midlertidig.settNeste(p);
    }
  }

  public void kassa(){
    while (forste != null){
      System.out.println("Behandler kunde: " + forste + ".");
      forste = forste.hentNeste();
    }

    System.out.println("Tomt for kunder!");
  }

}

class TestButikk{

  public static void main(String[] args){
    Butikk butikken = new Butikk();

    butikken.entreButikk(new Person("Stig", "Sitronsaft"));
    butikken.entreButikk(new Person("Hedda", "Engangskopper"));
    butikken.entreButikk(new Person("Jawad", "Pasta"));
    butikken.entreButikk(new Person("Henrik", "Kaffe"));
    butikken.entreButikk(new Person("Mathias", "Tomatsuppe"));

    butikken.kassa();
  }

}
