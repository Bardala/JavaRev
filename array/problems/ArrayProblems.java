class ArrayProblems{
	// helper function
	static void printArr(int[] arr) {
		for (int num: arr) System.out.print(num + "\t");
		System.out.println();
	}

	class AddEle{
		static int[] addEle(int[] nums, int ele){
			int[] res = new int[nums.length + 1];
			int i = 0;
			for (int num: nums) res[i++] = num;

			res[i] = ele;
			return res;
		}
	}

	class Print2DArr{
		static void print2DArr(int[][] arr) {
			for(int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
			}
		}

		static void usingSimpleLoop(int[][] arr) {
			for (int []nums: arr) {
				for (int num: nums) System.out.print(num + " ");
				System.out.println();
			}
		}
	}

	class TransposeArray{
		static int[][] transpose(int[][] nums) {
			int rows= nums.length, columns = nums[0].length;
			if (rows != columns) return new int[][] {{-1}};

			int[][] res = new int[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) res[j][i] = nums[i][j];
			}

			return res;
		}
	}

	class ArrayRotation {
		static int[] rotate(int[] nums, int d) {
			if (d > nums.length) {
				int rounds = d % nums.length;
				d = d - (rounds * nums.length);
			}

			int[] res = new int[nums.length];
			int i, j;
			for (i = 0, j = d; j < res.length; i++, j++) {
				 res[i] = nums[j];
			}
			j = 0;
			while (i < res.length) {
				res[i++] = nums[j++];
			}
			nums = res;
			return nums;
		}
	}

	public static void main(String args[]) {
		int[] newArr = AddEle.addEle(new int [] {1,2,3}, 4);
//		printArr(newArr);
		System.out.println();

		int arr[][] = new int [][] {{1,2,3}, {4,5,6}, {7,8,9}};
//		Print2DArr.print2DArr(nums);
//		Print2DArr.usingSimpleLoop(arr);
		System.out.println();

		int [][] trans = TransposeArray.transpose(arr);
//		Print2DArr.usingSimpleLoop(trans);

		int[] nums = {1,2,3,4,5,6,7};
		printArr(ArrayRotation.rotate(nums, 21));
		ArrayProblems ins = new ArrayProblems();
		ArrayProblems.ArrayRotation ar = ins.new ArrayRotation();
	}
}

