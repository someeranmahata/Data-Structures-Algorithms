package leetcode;
import java.util.*;
public class Leetcode{
	
	public static void main(String[] args){;
		int[] ar = {1,3,2};
		nextPermutation(ar);
		for(int i : ar)
			System.out.print(i + " ");
	}
	public static void nextPermutation(int[] nums) {
		boolean ans = false; int pos = 0;
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] < nums[j]){
					ans = true;
					break;
				}
			}
		}
		if(ans){
			for(int i = 0; i < nums.length - 1; i ++){
				if(nums[i] < nums[i + 1]){
					if(i + 2 == nums.length){
						nums[i] = nums[i] + nums[i+1];
						nums[i + 1] = nums[i] - nums[i+1];
						nums[i] = nums[i] - nums[i+1];
						return;
					}
					int temp = i + 1;
					for(int j = i + 2; j < nums.length; j++){
						if(nums[j] > nums[temp]){
							temp = j;
							break;
						}
					}
					nums[i + 1] = nums[temp] + nums[i + 1];
					nums[temp] = nums[i + 1] - nums[temp];
					nums[i + 1] = nums[i + 1] - nums[temp];
					return;
				}
			}
		}

		Arrays.sort(nums);
	}
 }