public class KoLapp{
  int nummer;
    //Konstruktor
    public KoLapp(int nummer){
      this.nummer = nummer;
      nummer++;
    }

    //Returnerer et tildelt nummer paa kolappen.
    public int hentNummer(){
      return this.nummer;
    }
}
