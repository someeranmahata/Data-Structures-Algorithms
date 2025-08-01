package leetcode;
import java.util.*;
public class Daily2419 {
    public static int longestSubarray(int[] nums) {
        int max = nums[0];
        if(nums.length == 1)    return 1;
        int cur = nums[0];
        int ans = 0;
        int len = 1;

        for(int i = 0; i < nums.length; i++){
            cur = nums[i];
            len = 1;

            for(int j = 1; j < nums.length; j++){
                cur = cur & nums[j];
                len++;
                if(cur > max){
                    max = cur;
                    ans = len;
                }
                if(cur == max)
                    ans = Math.max(ans, len);
            }
            if(cur > max)   ans = len;
            else if(cur == max) ans = Math.max(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {100,5,5};
        System.out.println(longestSubarray(num));
    }
}
