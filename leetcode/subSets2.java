import java.util.*;
public class subSets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(ans, temp, nums, 0);
        return ans;
    }
    public static void solve(List<List<Integer>> ans, List<Integer> temp, int[] ar, int k){
        if(k == ar.length){
            if(notinlist(ans, temp)){
                List<Integer> copy = new ArrayList(temp);
                copy.sort(null);
                ans.add(new ArrayList(copy));
                return;
            }
            return;
        }
        temp.add(ar[k]);
        solve(ans, temp, ar, k + 1);
        temp.remove(temp.size() - 1);
        solve(ans, temp, ar, k + 1);
    }
    public static boolean notinlist(List<List<Integer>> list, List<Integer> ele){
        List<Integer> copy = new ArrayList(ele);
        copy.sort(null);
        if(list.size() == 0)
            return true;

        for(List<Integer> temp : list){
            if(temp.equals(copy))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ar = {4,4,4,1,4};
        System.out.println(subsetsWithDup(ar));
    }
}