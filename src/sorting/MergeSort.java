package sorting;

public class MergeSort {

	public static void mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	public static void mergeSort(int[] array, int[] temp, int low, int high) {
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		mergeSort(array, temp, low, middle);
		mergeSort(array, temp, middle + 1, high);
		merge(array, temp, low, middle, high);
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int leftStart = low;
		int rightStart = middle + 1;
		int index = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (leftStart <= middle && rightStart <= high) {
			if (helper[leftStart] <= helper[rightStart]) {
				array[index] = helper[leftStart];
				leftStart++;
			} else {
				array[index] = helper[rightStart];
				rightStart++;
			}
			index++;
		}
		// Copy the rest of the left side of the array into the target array
		while (leftStart <= middle) {
			array[index] = helper[leftStart];
			index++;
			leftStart++;
		}

	}

	public static void main(String[] args) {
		int array[] = { 15, 4, 2, 6, 1, 7, 9, 10 };

		mergeSort(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
