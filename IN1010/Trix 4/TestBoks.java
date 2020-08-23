public class TestBoks{
  public static void main(String[] args){

    Boks b = new Boks(17, 17, 17);
    if (b.beregnAreal() == 1734){
      System.out.println("Riktig.");
    }
    else{
      System.out.println("Feil.");
    }

  }
}
