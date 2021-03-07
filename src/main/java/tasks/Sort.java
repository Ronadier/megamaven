package tasks;

import java.util.Arrays;

public class Sort {
  public static void main(String[] args) {
    int [] arr1 = {1, 2, 6, 7};
    int [] arr2 = {3, 4, 5};
    System.out.println(Arrays.toString(merge(arr1, arr2)));
  }

  public static int[] merge (int[] arr1, int[] arr2) {
    int[] sortedArray = new int[arr1.length + arr2.length];
    int i1 = 0;
    int i2 = 0;
    boolean isArr1Finish = false;
    boolean isArr2Finish = false;
    for (int iSort = 0; iSort < sortedArray.length; iSort++) {
      if (!isArr2Finish && (arr1[i1] > arr2[i2])) {
        sortedArray[iSort] = arr2[i2];
        i2++;
        if (i2 == arr2.length - 1) {
          isArr2Finish = true;
        }
      } else if (!isArr1Finish){
        sortedArray[iSort] = arr1[i1];
        i1++;
        if (i1 == arr1.length - 1) {
          isArr1Finish = true;
        }
      } else {
        throw new RuntimeException("Something went wrong");
      }
    }
    return sortedArray;
  }
}

//сортировка слиянием