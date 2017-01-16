package binarysearch;

public class FindElementInCirularlySortedArray {
	public static int findElementInCircularlySortedArray(int[] a, int data) {
		int n = a.length;
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (high + low) / 2;
			if (a[mid] == data) {
				// Case1: Element found
				return mid;
			}
			if (a[mid] <= a[high]) { // 2nd half is sorted
				if (data > a[mid] && data <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (a[low] <= a[mid]) { // 1st half is sorted
				if (data > a[low] && data <= a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int a[] = { 7, 8, 1, 2, 4, 5 };
		System.out.println(findElementInCircularlySortedArray(a, 8));
	}
}
