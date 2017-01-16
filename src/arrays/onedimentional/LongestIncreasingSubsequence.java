package arrays.onedimentional;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {

		int ans = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int count = 1;
			int current = nums[i];
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > current) {
					current = nums[j];
					count++;
				}
			}
			ans = Math.max(ans, count);
		}
		return ans;
	}

	public static void main(String args[]) {
		int input[] = { 10, 9, 2, 3, 4, 6, 1, 15, 16, 17, 18 };
		System.out.println(lengthOfLIS(input));
	}
}
