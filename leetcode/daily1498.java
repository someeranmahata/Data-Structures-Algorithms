package leetcode;
import java.util.*;
public class daily1498 {
    public static int numSubseq(int[] nums, int target) {
        return solve(nums, 0, target);
    }
    public static int solve(int[] nums, int st, int target){
        if(st >= nums.length){
            if(target == 0) return 1;
            else
                return 0;
        }
        if(target == 0) return 1;
        int ans = 0;
        for(int k = st; k < nums.length; k++){
            if((target - nums[k]) >= 0)
                ans += solve(nums, k + 1, target - nums[k]);
            else
                ans += solve(nums, k + 1, target);

        }
        return ans;
    }
    public static int solve1(int[] nums, int st, int target, List<Integer> list){
        if(st >= nums.length){
            if(list.get(0) + list.get(list.size() - 1) <= target)
                return 1;
            else return 0;
        }

        int ans = 0;
        for(int i = st; i<nums.length; i++){
            list.add(nums[i]);
            if(list.get(0) - list.get(list.size() - 1) <= target){
                ans += solve1(nums, i + 1, target, list);
            }
            list.remove(list.size() - 1);
        }
        return ans;
    }



    public static void main(String[] args){
        int[]  ar = {3,5,6,7};
        List<Integer> l = new ArrayList<>();
        System.out.println(solve1(ar, 0,9,l));
        System.out.println(numSubseq(ar, 9));
    }
}
