public class TestOrdbeholder{
  public static void main(String[] args){

    OrdBeholder ob = new OrdBeholder();
    if (ob.pop() == null){
      System.out.println("Riktig.");
    }
    else{
      System.out.println("Feil.");
    }

  }
}
