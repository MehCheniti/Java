class PGCD{

  public static void main(String[] args){
    System.out.println(calculDePGCD(24, 36));
  }

  static int calculDePGCD(int a, int b){
    if (a < b){
      int temp = a;
      a = b;
      b = temp;
    }

    int c = a % b;

    if (c == 0){
      return b;
    } else{
      a = b;
      b = c;
      return calculDePGCD(a, b);
    }
  }

}
