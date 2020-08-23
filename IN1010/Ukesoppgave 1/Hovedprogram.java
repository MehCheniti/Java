class Hovedprogram{

  public static void main(String[] args){
    Kanin kanin = new Kanin("Mehdi");
    Kaningaard kaningaard = new Kaningaard();

    System.out.println(kaningaard.full());
    System.out.println(kaningaard.tom());

    kaningaard.settInn(kanin);
    kaningaard.finnEn("Mehdi");
  }

}
