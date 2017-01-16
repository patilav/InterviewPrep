package sorting;

public class QuickSort {

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		}

		int pivotNumber = array[(leftIndex + rightIndex) / 2];
		int index = partition(array, leftIndex, rightIndex, pivotNumber);
		quickSort(array, leftIndex, index - 1);
		quickSort(array, index, rightIndex);
	}

	public static int partition(int[] array, int leftIndex, int rightIndex, int pivotNumber) {

		while (leftIndex <= rightIndex) {
			while (array[leftIndex] < pivotNumber) {
				leftIndex++;
			}

			while (array[rightIndex] > pivotNumber) {
				rightIndex--;
			}

			if (leftIndex <= rightIndex) {
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}

		return leftIndex;
	}

	public static void swap(int[] array, int lo, int hi) {
		int temp = array[lo];
		array[lo] = array[hi];
		array[hi] = temp;
	}

	public static void main(String args[]) {
		int[] array = new int[] { 15, 25, 10, 2, 51, 45, 31, 5, 95 };
		quickSort(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
