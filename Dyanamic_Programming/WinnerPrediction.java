package Dyanamic_Programming;
import java.util.*;
public class WinnerPrediction {
    public static boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }
    public static boolean solve(int[] nums, int i, int j, int sum1, int sum2, boolean turn){

        if(i == j){
            if(turn){
                sum1 += nums[i];
                return sum1 >= sum2;
            }
            else{
                sum2 += nums[j];
                return sum1 >= sum2;
            }
        }
        boolean ans = false;
        int start = nums[i];
        int last = nums[j];
        if(turn){
            ans =  solve(nums, i + 1, j, sum1 + start, sum2, false) || solve(nums, i, j - 1, sum1 + last, sum2, false);

        }
        if(!turn){
            ans = solve(nums, i + 1, j, sum1, sum2 + start, true) || solve(nums, i, j - 1, sum1, sum2 + last, true);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ar = {1,5,2};
        System.out.println(predictTheWinner(ar));
    }
}
