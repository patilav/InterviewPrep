package arrays.onedimentional;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {

		int[] e = { 1, 3, 5, 7, 9, 11, 13 };
		int[] f = { 2, 4, 6, 8 };

		double res = findMedianSortedArrays(e, f);
		System.out.println(res);
	}

	public static double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1) {
			return B[bStart + k - 1];
		}

		if (bStart > B.length - 1) {
			return A[aStart + k - 1];
		}

		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k / 2 - 1 < A.length) {
			aMid = A[aStart + k / 2 - 1];
		}

		if (bStart + k / 2 - 1 < B.length) {
			bMid = B[bStart + k / 2 - 1];
		}

		if (aMid < bMid)
			// Check: aRight + bLeft
			return getkth(A, aStart + k / 2, B, bStart, k - k / 2);
		else
			// Check: bRight + aLeft
			return getkth(A, aStart, B, bStart + k / 2, k - k / 2);
	}
}
