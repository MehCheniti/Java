//treningsoppgave 7.3

class Triangel {
  public static void main(String[] args) {
    triangle(3,5);

  }


  static void triangle(int m, int n) {
    if (m > n){
      return;
    }

    for (int i = 0; i < m; i++ ) {
      System.out.print('*');
    }
    System.out.println();

    triangle(m+1, n);

    for (int i = 0; i < m; i++ ) {
      System.out.print('*');
    }
    System.out.println();
  }

}
