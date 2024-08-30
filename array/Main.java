package array;

public class Main {
  static int getMin(int[] nums) {
    // if (nums.length == 0) {
    // throw new IllegalArgumentException("Current array is empty");
    // }
    int min = Integer.MAX_VALUE;

    for (int num : nums) {
      min = min > num ? num : min;
    }

    return min;
  }

  static void intro() {
    String[] strs = new String[5];
    System.out.println(strs.length);

    for (int i = 0; i < strs.length; i++)
      strs[i] = "" + i;

    for (String str : strs)
      System.out.print(str + " ");

    System.out.println();

    int[] nums = { 1, 4, 34, 44 };

    for (int num : nums)
      System.out.println(num);

    System.out.println(getMin(nums));

    System.out.println(getMin(new int[0]));
    System.out.println(getMin(new int[] { 43, 43, 1, 34, 543, 13, 0, -13 })); // Anonymous Array

    int arr[][] = new int[5][2];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = i + j;
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    // get the name of the class
    String className = arr.getClass().getName();
    System.out.println("Class name of array" + className); // [[I
    System.out.println("Class name of string" + "".getClass().getName()); // java.lang.String

    int nums1[] = { 1, 2, 3, 4 };
    int nums2[] = nums1;

    nums2[0] = 10;
    printArr(nums1); // 10, 2, 3, 4

    // Copying array elements into another array
    char[] arrayFrom = { 'c', 'v' };
    char[] copyTo = new char[3];

    System.arraycopy(arrayFrom, 0, copyTo, 0, 2);
    printArr(copyTo);

    System.out.println();
  }

  static void printArr(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  static void printArr(char[] chars) {
    for (char c : chars)
      System.out.print(c + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    intro();
  }
}
