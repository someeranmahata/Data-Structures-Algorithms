package Dyanamic_Programming;
import java.util.*;
public class EqualSum {

    public static void main(String[] args){
        int[] nums = {10, 6, 3, 1};
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            System.out.println(false);
        else if(sum % 2 == 0) {
            int tar = sum / 2;
            int n = nums.length;
            boolean[][] arr = new boolean[n + 1][tar + 1];

            subsetSum obj = new subsetSum();
            boolean ans = obj.Possible(nums, tar);
            System.out.println(ans);
        }
    }

}
