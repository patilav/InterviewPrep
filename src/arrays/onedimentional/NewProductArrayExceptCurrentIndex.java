package arrays.onedimentional;

public class NewProductArrayExceptCurrentIndex {

	public static int[] newProductArrayExceptCurrentIndex(int[] array) {
		int[] output = new int[array.length];

		if (array.length == 0) {
			return output;
		}

		int product = 1;
		for (int i : array) {
			product = product * i;
		}

		if (product == 0) {
			return output;
		}

		for (int i = 0; i < array.length; i++) {
			output[i] = product / array[i];
		}

		return output;
	}

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5 };

		int output[] = newProductArrayExceptCurrentIndex(array);

		for (int i : output) {
			System.out.print(i + " ");
		}
	}
}
