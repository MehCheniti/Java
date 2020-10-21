import java.util.Scanner;

public class MissingNumber{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    // System.out.println("How many numbers?");
    long i = scan.nextInt();
    // int[] arr = new int[i - 1];
    // System.out.println("Input the numbers, between 1 and " + i +
    // " (both inclusive).");
    long arraySum = 0;

    for (int x = 0; x < i - 1; x++){
      // int y = scan.nextInt();
      // if (y >= 1 && y <= i){
      //   arr[x] = y;
      //   arraySum += y;
      // } else{
      //   x--;
      // }
      long y = scan.nextInt();
      arraySum += y;
    }

    long sum = i * (i + 1) / 2;
    // System.out.println("The missing number is " + (sum - arraySum) + ".");
    System.out.println((sum - arraySum));
  }

}
