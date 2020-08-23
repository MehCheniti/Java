class Algoritmer{

  public static void insertionSort(int[] array){
    for (int i = 1; i < array.length; i++){
      int x = array[i];
      int y = i - 1;
      while (x < array[y] && y >= 0){
        array[y + 1] = array[y];
        y--;
      }
      array[y + 1] = x;
    }
  }

  public static void quickSort(int[] array, int start, int end){
    while (start < end){
      int l = partition(array, start, end);
      if (l-1 < end-1){
        quickSort(array, start, l-1);
        start = l + 1;
      } else{
        quickSort(array, l+1, end);
        end = l - 1;
      }
    }
  }

  public static int partition(int[] array, int start, int end){
    int pivot = array[end];
    int left = start;
    int right = end - 1;
    int temp = array[right];

    while (left <= right){
      while (left <= right && array[left] < pivot){
        left++;
      }
      while (right >= left && array[right] > pivot){
        right--;
      }
      if (left < right){
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
      }
    }

    temp = array[left];
    array[left] = array[end];
    array[end] = temp;
    return left;
  }

  public static void mergeSort(int[] array, int start, int end){
    if (start < end){
      int mid = (start + end) / 2;
      mergeSort(array, start, mid);
      mergeSort(array, mid + 1, end);
      merge(array, start, mid, end);
    }
  }

  public static void merge(int[] array, int start, int mid, int end){
    int x = start;
    int y = mid + 1;
    int temp = 0;
    int[] tempArray = new int[end - start + 1];

    while (x <= mid && y <= end){
      if (array[x] <= array[y]){
        tempArray[temp] = array[x];
        x++;
        temp++;
      } else{
        tempArray[temp] = array[y];
        y++;
        temp++;
      }
    }

    while (x <= mid){
      tempArray[temp] = array[x];
      x++;
      temp++;
    }

    while (y <= end){
      tempArray[temp] = array[y];
      y++;
      temp++;
    }

    for (int i = start; i <= end; i++){
      array[i] = tempArray[i - start];
    }
  }

  public static void main(String[] args){
    int[] array = {5, 17, 34, 10};
    int n = array.length;

    // // Insertion-sort:
    //
    // System.out.println("");
    // System.out.println("Before: ");
    //
    // for (int i : array){
    //   System.out.println(i);
    // }
    //
    // System.out.println("");
    // System.out.println("After: ");
    // insertionSort(array);
    //
    // for (int i : array){
    //   System.out.println(i);
    // }
    //
    // // Quick-sort:
    //
    // System.out.println("");
    // System.out.println("Before: ");
    //
    // for (int i : array){
    //   System.out.println(i);
    // }
    //
    // System.out.println("");
    // System.out.println("After: ");
    // quickSort(array, 0, n-1);
    //
    // for (int i : array){
    //   System.out.println(i);
    // }
    //
    // // Merge-sort:
    //
    // System.out.println("");
    // System.out.println("Before: ");
    //
    // for (int i : array){
    //   System.out.println(i);
    // }
    //
    // System.out.println("");
    // System.out.println("After: ");
    // mergeSort(array, 0, n - 1);
    //
    // for (int i : array){
    //   System.out.println(i);
    // }
  }

}
