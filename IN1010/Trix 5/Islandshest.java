public class Islandshest extends Hest implements KanToelte, KanPasse{

  String navn;
  int alder;

  public Islandshest(String navn, int alder){
    super(navn, alder);
    this.navn = navn;
    this.alder = alder;
  }

  public void toelt(){
    System.out.println("Kan toelte.");
  }

  public void pass(){
    System.out.println("Kan passe.");
  }

}
