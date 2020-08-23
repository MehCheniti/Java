class BinaerUtskrift{

  static void skrivUtBinaer(int n){
    if (n == 0){
      System.out.println(0);
    } else{
      if (n > 1){
        skrivUtBinaer(n / 2);
      }
      System.out.println(n%2);
    }
  }

  public static void main(String[] args){
    skrivUtBinaer(27);
  }

}
