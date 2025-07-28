package leetcode;
import java.util.*;
public class Daily2210 {
    public static int countHillValley(int[] nums) {
        List<List<Integer>> dp = new ArrayList<>();
        int n = nums.length;
        int count = 0;
        for(int i = 1; i < n - 1; i++){
            int left = i - 1;
            int right = i + 1;
            while(left != -1 && nums[i] == nums[left]){
                left--;
            }
            while(right != n && nums[i] == nums[right]){
                right++;
            }
            if(left != -1 && right != n){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                if(left != -1 && right != n && !dp.contains(temp)){
                    if(nums[left] < nums[i] && nums[right] < nums[i])
                        count++;
                    else if(nums[left] > nums[i] && nums[right] > nums[i])
                        count++;
                    dp.add(temp);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ar = {2,4,1,1,6,5};
        System.out.println(countHillValley(ar));
    }
}
