import java.util.*;

public class WeeklyD{
    public static long maxSumTrionic(int[] nums) {
        boolean st = false;
        boolean mid = false;
        boolean end = false;

        long ans = Long.MIN_VALUE;
        for(int j = 0; j < nums.length - 1; j++){
            long sum = 0 + nums[j];
            int i = j;
            if(! st && nums[i] < nums[i + 1])
            {
                while(i < nums.length - 1 && nums[i] < nums[i + 1]){
                    sum += nums[i + 1];
                    i++;

                }
                st = true;
            }
            if(!st)
                continue;
            if(i < nums.length - 1 && !mid && nums[i] > nums[i + 1]){
                while(i < nums.length - 1 && nums[i] > nums[i + 1]){
                    sum += nums[i + 1];
                    i++;
                }
                mid = true;
            }
            if(!mid) continue;
            if(i < nums.length - 1 &&  !end && nums[i] < nums[i + 1]){
                while(i < nums.length - 1 && nums[i] < nums[i + 1]){
                    sum += nums[i + 1];
                    ans = Math.max(sum, ans);
                    i++;
                }

                ans = Math.max(ans, sum);

            }
            st = false;
            end = false;
            mid = false;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] ar  = {1,4,2,7};
        System.out.println(maxSumTrionic(ar));
    }

}