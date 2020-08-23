class Reverser{

  static int sum = 0;
  static String stjerne = "*";

  public static void main(String[] args){
    int[] reverse = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int i = 0; i < 10; i++){
      System.out.println(reverse[i]);
    }

    for (int i = 9; i >= 0; i--){
      System.out.println(reverse[i]);
    }

    for (int i = 0; i < 10; i++){
      sum += reverse[i];
      System.out.println(sum);
    }

    String[] stjerner = new String[10];
    for (int i = 0; i < stjerner.length; i++){
      stjerner[i] = "*";
    }
    for (int i = 0; i < stjerner.length; i++){
      System.out.println(stjerne);
      stjerne += "*";
    }
  }

}
