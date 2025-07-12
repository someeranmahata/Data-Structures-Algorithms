package leetcode;
import java.util.*;
public class Majorelement {
    public static int majorityElement(int[] nums) {
        if(nums.length == 1)    return nums[0];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            if(hm.containsKey(i))
                hm.put(i, hm.get(i) + 1);
            else
                hm.put(i, 1);
        }
        System.out.println(hm);
        int comp = Integer.MIN_VALUE;
        int ans = nums[0];
        for(Map.Entry<Integer, Integer> n : hm.entrySet()){
            if(comp < n.getValue()){
                comp = n.getValue();
                ans = n.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ar = {2,0,-1,-1,0,2,0,0,0};
        System.out.println(majorityElement(ar));
    }
}
