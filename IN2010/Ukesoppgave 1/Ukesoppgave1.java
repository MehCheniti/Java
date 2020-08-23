import java.util.*;

class Ukesoppgave1{

  public static void main(String[] args){
    int arr[] = {1, 3, 5};
    notInRange(arr, 1, 5);

    int arr2[] = {0, 0, 0, 1, 1, 1};
    System.out.println(countOnes(arr));
  }

  static void notInRange(int arr[], int low, int high){
    HashSet<Integer> hs = new HashSet<>();

    for (int i = 0; i < arr.length; i++){
      hs.add(arr[i]);
    }

    for (int i = low; i <= high; i++){
      if (!hs.contains(i)){
        System.out.println(i);
      }
    }
  }

  static int countOnes(int arr[]){
    int sum = 0;

    for (int i = 0; i < arr.length; i++){
      sum += i;
    }

    return sum;
  }

}

class Partition {
public static int sum(int[] mset) {
int sum = 0;
for (int i : mset) {
sum += i;
}
return sum;
}
public static int[] partition(int[] mset) {
int n = mset.length;
int m = sum(mset);
// Check bitstrings from 0 to 2^(n-1)
// Possible as the last element could be a part of the other subset wlog
for (int i = 0; i < Math.pow(2, n-1); i++) {
int[] subset = new int[n];
for (int j = 0; j < n; j++) {
// If the bit is set at position j, include the value
if ((i >> j & 1) == 1) {
subset[j] = mset[j];
}
}
if (sum(subset) * 2 == m) {
return subset;
}
}
return null;
}
public static void main(String[] args) {
int[] mset = {1, 2, 3, 4};
int[] solution = partition(mset);
System.out.println(Arrays.toString(solution));
}
}
