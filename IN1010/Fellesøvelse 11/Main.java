import java.util.Random;
import java.util.Arrays;

public class Main{

  public static void main(String[] args){
    int[] original = new int[110000];
    Random rand = new Random(42);

    for (int i = 0; i < original.length; i++){
      original[i] = rand.nextInt(20000);
    }

    // System.out.println("Array: " + Arrays.toString(original));.

    int sekRes = Sekvensiell.finnMax(original);
    System.out.println("Storste tallet er: " + sekRes + ".");
    int paraRes = Parallel.finnMax(original, 64);
    System.out.println("Storste tallet er: " + paraRes + ".");
  }

}
