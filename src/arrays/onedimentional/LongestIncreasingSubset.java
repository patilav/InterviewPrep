package arrays.onedimentional;

public class LongestIncreasingSubset {
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
				} else {
					ans = Math.max(ans, count);
					i = j - 1;
					break;
				}
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		int input[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(input));
	}
}
