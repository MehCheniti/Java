public class Melding implements Comparable<Melding>{

private String innhold;
private int sekvensnummer;
private int ID;

  public Melding(String innhold, int sekvensnummer, int ID){
    this.innhold = innhold;
    this.sekvensnummer = sekvensnummer;
    this.ID = ID;
  }

  public String hentInnhold(){
    return innhold;
  }

  public int hentSekvensnummer(){
    return sekvensnummer;
  }

  public int hentID(){
    return ID;
  }

  public int compareTo(Melding melding){
    if (sekvensnummer > melding.hentSekvensnummer()){
      return 1;
    } else if (sekvensnummer < melding.hentSekvensnummer()){
      return -1;
    } else{
      return 0;
    }
  }

}
