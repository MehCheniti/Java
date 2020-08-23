public class Kjoretoy implements Reparasjon{

  int registreringsnummer;
  String type;
  String beskrivelse;
  int kostnad;
  int dato;
  int id;
  static int teller = 0;

  public Kjoretoy(int registreringsnummer, String type){
    this.registreringsnummer = registreringsnummer;
    this.type = type;
    this.beskrivelse = beskrivelse;
    this.kostnad = kostnad;
    this.dato = dato;
  }

  public void settBeskrivelse(String beskrivelsen){
    beskrivelse = beskrivelsen;
  }

  public void settKostnad(int kostnaden){
    kostnad = kostnaden;
  }

  public void utfortDato(int datoen){
    dato = datoen;
    id = teller++;
  }

  @Override public String toString(){
    return "Registreringsnummer: " + registreringsnummer + ", type: " + type +
    ", beskrivelse: " + beskrivelse + ", kostnad: " + kostnad + ", dato: " +
    dato + ".";
  }

}
