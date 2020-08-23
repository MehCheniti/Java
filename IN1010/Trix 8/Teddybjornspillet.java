class Teddybjornspillet{

  public static void main(String[] args){
    System.out.println(teddy(42));
  }

  static boolean teddy(int n){
    if (n == 42){
      return true;
    }

    if (n%5 != 0 && n%2 != 0 && n%3 != 0 && n%4 != 0){
      return false;
    }

    boolean oha1 = true;
    boolean oha2 = true;
    boolean oha3 = true;

    if (n%5 == 0){
      oha1 = teddy(n - 42);
    }

    if (n%2 == 0){
      oha2 = teddy(n / 2);
    }

    if (n%3 == 0 || n%4 == 0){
      oha3 = teddy((n % 10) * ((n % 100) / 10));
    }

    return (oha1 || oha2 || oha3);
  }

}
