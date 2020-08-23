class TestBST{

  public static void main(String[] args){
    BinaertSokeTre treet = new BinaertSokeTre();
    treet.settInn(40);
    treet.settInn(20);
    treet.settInn(32);
    treet.settInn(12);
    treet.settInn(6);
    treet.skrivUt();
    System.out.println("Storrelse paa BST: " + treet.storrelse() + ".");
  }

}
