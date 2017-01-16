package arrays.onedimentional;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < nums.length; i ++){
        	nums[(nums[i]-1) % n] =  nums[(nums[i]-1) % n]+ n;
        }

        for (int i = 0; i < nums.length; i ++) {
        	if (nums[i] <= n) res.add(i+1);
        }
        
        return res;
    }
	
	public static List<Integer> findDisappearedNumbersImproved(int[] nums) {
	        ArrayList<Integer> disappearedList =  new ArrayList<>();
	        int n = nums.length;
	        if(n == 0){
	            return disappearedList;
	        }
	        
	        for(int i = 0; i<n;i++){
	            nums[(nums[i]-1) % n] = nums[(nums[i]-1) % n] + n;
	        }
	        
	        for(int i = 0; i<n;i++){
	            if(nums[i]<=n){
	                disappearedList.add(i+1);
	            }
	        }
	        return disappearedList;
	    }
	
	public static void main(String args[]){
		int nums[] = new int[]{1,2,2,4};
		
		List<Integer> res = findDisappearedNumbersImproved(nums);
		for(int i: res){
			System.out.print(i+ " ");
		}
	}
}
