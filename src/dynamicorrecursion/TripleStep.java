package dynamicorrecursion;

import java.util.Arrays;

public class TripleStep {

	public static long countWays(int n, long[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}

	public static void main(String args[]) {
		long memo[] = new long[25 + 1];
		Arrays.fill(memo, -1);
		long ans = countWays(25, memo);
		System.out.println(ans);
	}
}
