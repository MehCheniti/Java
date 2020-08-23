public class Verksted{

  Lenkeliste<Kjoretoy> kjoretoy = new Lenkeliste<Kjoretoy>();
  Lenkeliste<Kjoretoy> reparasjoner = new Lenkeliste<Kjoretoy>();

  public void registrerKjoretoy(int registreringsnummer, String type){
    kjoretoy.leggTil(new Kjoretoy(registreringsnummer, type));
  }

  public void registrerReparasjon(int registreringsnummer, String beskrivelse,
  int kostnad, int dato){
    // Her antar jeg at registreringsnummeret er lik indeksen på lenkelisten.
    // Kunne gjerne ha godt gjennom listen og sammenlignet
    // registreringsnummeret men mangler litt tid.
    Kjoretoy nyttKjoretoy = kjoretoy.hent(registreringsnummer);

    nyttKjoretoy.settBeskrivelse(beskrivelse);
    nyttKjoretoy.settKostnad(kostnad);
    nyttKjoretoy.utfortDato(dato);
  }

  public void hentInfo(int id){
    for (Kjoretoy k : kjoretoy){
      if (id == k.id) System.out.println(k.toString());
    }
  }

}
