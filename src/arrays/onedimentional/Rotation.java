package arrays.onedimentional;

public class Rotation {

	public static void leftRotate(int arr[], int rotations) {
		int n = arr.length;

		for (int j = 0; j < rotations; j++) {
			// store the first element
			int temp = arr[0];
			for (int i = 1; i < n; i++) { // shift the element to left by 1
				arr[i - 1] = arr[i];
			}
			// put the stored element at last
			arr[n - 1] = temp;
		}
	}
	
	public static void rightRotate(int arr[], int rotations) {
		int n = arr.length;
		
		if(n==0 || n==1 || rotations == 0){
			//if empty array or it has only 1 element or there are no rotations.
			return;
		}
		
		for (int j = 0; j < rotations; j++) {
			// store the first element
			int temp = arr[n-1];
			for (int i = n-1; i > 0; i--) { // shift the element to left by 1
				arr[i] = arr[i-1];
			}
			// put the stored element at last
			arr[0] = temp;
		}
	}

	public static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {

		int arr[] = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println("Rotate Left");
//		leftRotate(arr, 3);
//		printArray(arr);
		
		System.out.println("\nRotate Right");
		arr= new int[] { 1, 2, 3, 4, 5 };
		rightRotate(arr, 0);
		printArray(arr);
		rightRotate(arr, 5);
		printArray(arr);
	}
}
