package binarysearch;

public class SortOneAndZero {
	public static void sortOneAndZero(int nums[]) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			if (nums[low] == 0 && nums[high] == 0) {
				// Both are zero
				low++;
			} else if (nums[low] == 1 && nums[high] == 1) {
				// Both are 1
				high--;
			} else if (nums[low] == 0 && nums[high] == 1) {
				// Already in order
				low++;
				high--;
			} else if (nums[low] == 1 && nums[high] == 0) {
				// Not sorted
				swap(nums, low, high);
				low++;
				high--;
			}
		}
	}

	private static void swap(int nums[], int low, int high) {
		int temp = nums[low];
		nums[low] = nums[high];
		nums[high] = temp;
	}

	public static void main(String args[]) {
		int nums[] = { 0, 1, 1, 0, 0, 1, 0, 1, 0 };

		sortOneAndZero(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}
