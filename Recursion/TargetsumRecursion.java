import java.util.*;

public class TargetsumRecursion {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ar = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        combinationSum(ar, current, candidates, target, 0);
        return ar;
    }
    public static void combinationSum(List<List<Integer>> ans, List<Integer> temp, int[] ar, int target, int ind){
        if(target == 0){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int i = ind; i < ar.length; i++){
            if(ar[i] <= target){
                temp.add(ar[i]);
                combinationSum(ans, temp, ar, target - ar[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
    //combination sum 3
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] count = new int[1];
        combinationSum3(ans, temp, k, n, count);
        System.out.println(count[0]);
        return ans;
    }

    public static void combinationSum3(List<List<Integer>> ans, List<Integer> temp, int count, int sum, int[] c)
    {
        if(sum == 0 && count == 0){
            ans.add(new ArrayList(temp));
            c[0] += 1;
            return;
        }
        int st = 1;
        if(temp.size() != 0)
            st = temp.get(temp.size() - 1) + 1;

        for(int i = st; i <= 9 && count != 0; i++){
            if(i <= sum){
                temp.add(i);
                combinationSum3(ans, temp, count - 1, sum - i,c);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] ar = {2,3,6,7};
        System.out.println(combinationSum3(3, 9));

    }
}
