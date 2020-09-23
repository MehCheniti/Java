import java.util.Scanner;

public class MissingNumber{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    //System.out.println("How many numbers?");
    int i = scan.nextInt();
    int[] arr = new int[i - 1];
    //System.out.println("Input the numbers, between 1 and " + i +
    //" (both inclusive).");
    int arraySum = 0;

    for (int x = 0; x < arr.length; x++){
      int y = scan.nextInt();
      if (y >= 1 && y <= i){
        arr[x] = y;
        arraySum += y;
      } else{
        x--;
      }
    }

    int sum = i * (i + 1) / 2;
    //System.out.println("The missing number is " + (sum - arraySum) + ".");
    System.out.println((sum - arraySum));
  }

}
