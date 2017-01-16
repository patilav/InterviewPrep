package arrays.onedimentional;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
	}

	public static void combinationSum(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target,
			int start) {
		if (target > 0) {
			for (int i = start; i < candidates.length; i++) { 
				cur.add(candidates[i]);
				combinationSum(result, cur, candidates, target - candidates[i], i+1);
				cur.remove(cur.size() - 1);
			}
		}
		if (target == 0)
			result.add(new ArrayList<Integer>(cur));
	}

	public static void main(String args[]) {
		int[] candidates = new int[] { 1, 3, 2, 2, 4, 5, 7, 8, 3 };
		List<List<Integer>> result = combinationSum(candidates, 5);
		
		for(List<Integer> list: result){
			for(int i: list){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		boolean isNegative = false;
		if(target<0){
			isNegative = true;
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum1(result, new ArrayList<Integer>(), candidates, target, 0, isNegative);
		return result;
	}

	public static void combinationSum1(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target,
			int start, boolean isNegative) {
		if ((target > 0 && !isNegative) || (target < 0 && isNegative)) {
			for (int i = start; i < candidates.length; i++) { 
				cur.add(candidates[i]);
				combinationSum1(result, cur, candidates, target - candidates[i], i+1, isNegative);
				cur.remove(cur.size() - 1);
			}
		}
		if (target == 0)
			result.add(new ArrayList<Integer>(cur));
	}
}
