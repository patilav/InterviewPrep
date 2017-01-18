package binarysearch;

public class BinarySearch {
	public int search(final int input[], int search) {
		int low = 0;
		int high = input.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + ((high - low) / 2);
			if (input[mid] == search) {
				return mid;
			} else if (search < input[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(mid);
		return -1;
	}
	
	public int searchVal (int input[] , int num) {
		int mid = -1;
		int low = 0;
		int high = input.length -1;
		while(low<=high) {
			mid = low + ((high - low) / 2);
			if (input[mid] == num) {
				return mid;
			} else if (num < input[mid]) { 
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public int searchDirectional(final int input[], int search, boolean first) {
		int low = 0;
		int high = input.length - 1;
		int index = -1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (input[mid] == search) {
				index = mid;
				if (first) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			} else if (search < input[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

	public int searchFirst(final int input[], int search) {
		int low = 0;
		int high = input.length - 1;
		int lowindex = -1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (input[mid] == search) {
				lowindex = mid;
				high = mid - 1;
			} else if (search < input[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return lowindex;
	}

	public int searchLast(final int input[], int search) {
		int low = 0;
		int high = input.length - 1;
		int lowindex = -1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (input[mid] == search) {
				lowindex = mid;
				low = mid + 1;
			} else if (search < input[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return lowindex;
	}

	public static void main(String args[]) {
		BinarySearch bSearch = new BinarySearch();
		final int arr1[] = { 1, 2, 2, 4, 5, 7, 7, 7, 8 };
		System.out.println(bSearch.searchVal(arr1, -1));
		System.out.println(bSearch.searchVal(arr1, 1));
		System.out.println(bSearch.searchVal(arr1, 8));
		System.out.println(bSearch.searchVal(arr1, 2));

		System.out.println("Find First Occurance");
		System.out.println(bSearch.searchFirst(arr1, 2));
		System.out.println(bSearch.searchFirst(arr1, 7));

		System.out.println("Find Last Occurance");
		System.out.println(bSearch.searchLast(arr1, 2));
		System.out.println(bSearch.searchLast(arr1, 7));

		System.out.println(bSearch.searchFirst(arr1, 2));
		System.out.println(bSearch.searchLast(arr1, 7));
	}
}
