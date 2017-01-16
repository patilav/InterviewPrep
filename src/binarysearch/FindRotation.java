package binarysearch;

public class FindRotation {

	public static int findRotation(int[] a) {
		int n = a.length;
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			// Case 1: array not rotated at all
			if (a[low] <= a[high]) {
				return low;
			}
			int mid = (low + high) / 2;
			int next = (mid + 1) % n;
			int prev = (mid + n - 1) % n;
			// Case 2: check pivot property
			if (a[mid] <= a[next] && a[mid] <= a[prev]) {
				return mid;
			}
			// Case 3: if 2nd half is sorted
			if (a[mid] <= a[high]) {
				high = mid - 1;
			}
			// Case 4: if first half is sorted
			if (a[mid] >= a[low]) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String args[]) {
		int a[] = { 7, 8, 1, 2, 4, 5 };
		System.out.println(findRotation(a));
	}
}
