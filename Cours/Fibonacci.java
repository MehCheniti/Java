class Fibonacci{

  public static void main(String[] args){
    System.out.println(fibonacciIterative(5));
    System.out.println(fibonacciRecursive(5));
  }

  static int fibonacciIterative(int n){
    if (n <= 1){
      return n;
    } else{
      int x = 1;
      int y = 1;
      for (int i = 2; i < n; i++){
        int z = x;
        x += y;
        y = z;
      }
      return x;
    }
  }

  static int fibonacciRecursive(int n){
    if (n <= 1){
      return n;
    } else{
      return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
  }

}

// La variante preferable ici est la recursive, car elle demande beaucoup moins
// de lignes de code.
