package arrays.onedimentional;

import java.util.HashSet;

public class TwoSumMultiplePairs {
	
	public static void twoSum(int[] nums, int target) {
        HashSet<Integer> numbers = new HashSet<>();
        
        for(int i = 0; i< nums.length; i++){
        	int remaining = target - nums[i];
        	if(numbers.contains(remaining)){
        		System.out.println(remaining +" "+ nums[i]);
        	}else{
        		numbers.add(nums[i]);
        	}
        }
    }
	
	public static void main(String args[]){
		int nums[] = {-2,2,2,12,16};
		twoSum(nums, 14);
	}
}
