package programs;

public class BubbleSort {

  static void sort(int nums[]) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }

  static void printArr(int nums[]) {
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int nums[] = { 32, 2, 89, -34, 0 };
    sort(nums);
    printArr(nums);
  }
}
