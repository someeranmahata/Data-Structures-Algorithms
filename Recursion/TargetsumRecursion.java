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

    public static void main(String[] args) {
        int[] ar = {2,3,6,7};
        System.out.println(combinationSum(ar, 7));
    }
}
