package arrays.onedimentional;

public class StreamWhenWillItDie {

	public static void checkWhenWillItDie(int array[], int deletionSequece[], int num) {

		int index = findIndex(array, num);
		if (index == -1) {
			System.out.println("Number not present");
		}

		for (int j = 0; j < deletionSequece.length; j++) {
			int currentSeqence = deletionSequece[j];
			if(currentSeqence == 1){
				System.out.println("Will die at:" + currentSeqence);
				return;
			}
			
			if(index == -1){
				System.out.println("Will not die");
				return;
			}
			if (((index % currentSeqence) - (currentSeqence - 1)) == 0) {
				System.out.println("Will die at:" + currentSeqence);
				return;
			} else {
				index = index - (index/ currentSeqence);
			}
		}
		System.out.println("Will not die");

	}

	public static int findIndex(int array[], int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int deletionSequece[] = { 2, 3, 4 };

		checkWhenWillItDie(array, deletionSequece, 9);
	}
}
