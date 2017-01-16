package binarysearch;

public class SortZerosOneAndTwo {

	public static void sort012(int a[]) {
		int lo = 0;
		int hi = a.length - 1;
		int mid = 0;
		while (mid <= hi) {
			if (a[mid] == 0) {
				swap(a, lo, mid);
				lo++;
				mid++;
			} else if (a[mid] == 1) {
				mid++;
			} else {
				swap(a, mid, hi);
				hi--;
			}
		}
	}

	private static void swap(int nums[], int low, int high) {
		int temp = nums[low];
		nums[low] = nums[high];
		nums[high] = temp;
	}

	public static void main(String args[]) {
		int nums1[] = { 0, 1, 1, 2, 0, 0, 1, 2, 2, 0, 1, 0, 2 };

		sort012(nums1);
		for (int i : nums1) {
			System.out.print(i + " ");
		}
	}
}
