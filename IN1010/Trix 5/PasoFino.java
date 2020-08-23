abstract class PasoFino extends Hest implements KanToelte, KanPasse{

  String navn;
  int alder;

  public PasoFino(String navn, int alder){
    super(navn, alder);
    this.navn = navn;
    this.alder = alder;
  }

  public void toelt(){
    System.out.println("Kan toelte.");
  }

}
