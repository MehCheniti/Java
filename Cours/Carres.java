class Carres{

  public static void main(String[] args){
    System.out.println(sumCarres(3));

    int[] t = {1, -2, 3, 6};
    System.out.println(sumOfInt(t, 0));
  }

  static int sumCarres(int n){
    if (n == 1){
      return 1;
    } else{
      return (n * n + sumCarres(n - 1));
    }
  }

  static int sumOfInt(int[] arr, int ind){
    if (ind >= arr.length){
      return 0;
    } else if (ind >= 0){
      if (arr[ind] > 0){
        return arr[ind] + sumOfInt(arr, ind + 1);
      } else{
        return sumOfInt(arr, ind + 1);
      }
    } else{
      return 0;
    }
  }

}
