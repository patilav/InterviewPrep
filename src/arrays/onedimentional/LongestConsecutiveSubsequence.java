package arrays.onedimentional;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

	public static int longestConsecutive(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		HashSet<Integer> numbers = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			numbers.add(nums[i]);
		}

		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			// check if a smaller number exists than the current number;
			if (!numbers.contains(nums[i] - 1)) {
				int j = nums[i]; // smallest number

				// traverse the sequence
				while (numbers.contains(j)) {
					j++;
				}

				ans = Math.max(ans, j - nums[i]);

				if (ans == nums.length) {
					// if whole array is a sequence
					break;
				}
			}
		}

		return ans;
	}

	public static void main(String args[]) {
		int input[] = { 3, 5, 4, 2 };
		System.out.println(longestConsecutive(input));
	}
}
