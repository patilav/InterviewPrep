package arrays.onedimentional;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSumSinglePair {

	public static int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        HashSet<Integer> numbers = new HashSet<>();
        
        for(int i = 0; i< nums.length; i++){
        	int remaining = target - nums[i];
        	if(numbers.contains(remaining)){
        		pair[0] = remaining;
        		pair[1] = nums[i];
        		return pair;
        	}else{
        		numbers.add(nums[i]);
        	}
        }
        
        return pair;
    }
	
	public static int[] twoSumIndex(int[] nums, int target) {
        int[] pair = new int[2];
        HashMap<Integer,Integer> numbers = new HashMap<>();
        
        for(int i = 0; i< nums.length; i++){
        	int remaining = target - nums[i];
        	if(numbers.containsKey(remaining)){
        		pair[0] = numbers.get(remaining);
        		pair[1] = i;
        		return pair;
        	}else{
        		numbers.put(nums[i], i);
        	}
        }
        
        return pair;
    }
	
	public static void main(String args[]){
		int nums[] = {-2,2,12,15};
		int output[] = twoSumIndex(nums, 13);
		
		for(int i: output){
			System.out.print(i+" ");
		}
	}
}
