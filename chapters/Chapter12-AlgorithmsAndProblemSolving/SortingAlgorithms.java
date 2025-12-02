package chapters.Chapter12_AlgorithmsAndProblemSolving;

/**
 * [ADDED BY ASSISTANT]
 * Sorting Algorithms Implementations
 * Includes Bubble Sort, Merge Sort, Quick Sort with complexity analysis
 */
public class SortingAlgorithms {

  // Bubble Sort - O(n²)
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  // Merge Sort - O(n log n)
  public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    while (i <= mid)
      temp[k++] = arr[i++];
    while (j <= right)
      temp[k++] = arr[j++];

    System.arraycopy(temp, 0, arr, left, temp.length);
  }

  // Quick Sort - O(n log n) average
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }

  // Utility to print array
  private static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("=== Sorting Algorithms Example ===\n");

    int[] arr1 = { 64, 34, 25, 12, 22, 11, 90 };
    int[] arr2 = arr1.clone();
    int[] arr3 = arr1.clone();

    System.out.println("Original array: ");
    printArray(arr1);

    bubbleSort(arr1);
    System.out.println("After Bubble Sort: ");
    printArray(arr1);

    mergeSort(arr2, 0, arr2.length - 1);
    System.out.println("After Merge Sort: ");
    printArray(arr2);

    quickSort(arr3, 0, arr3.length - 1);
    System.out.println("After Quick Sort: ");
    printArray(arr3);
  }
}
