class Triangel{

  static void triangel(int m, int n){
    String s = "";

    for (int i = 0; i < m; i++){
      s += "*";
    }

    System.out.println(s);

    if (m == n){
      System.out.println(s);
      return;
    }

    triangel(m + 1, n);
    System.out.println(s);
  }

}
