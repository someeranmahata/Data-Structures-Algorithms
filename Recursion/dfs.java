import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dfs {
    public static List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ele = new ArrayList<Integer>();
        DFS(cand, 0, target, ele, ans);
        return ans;
    }
    public static void DFS(int[] ar, int cur, int tar, List<Integer> ele, List<List<Integer>> ans){
        if(tar == 0){
            ans.add(new ArrayList<>(ele));
            return;
        }
        if(tar < 0)
            return;
        for(int i = cur; i < ar.length; i++){
            if(i > cur && ar[i] == ar[i-1])
                continue;
            ele.add(ar[i]);
            DFS(ar, i+1, tar-ar[i], ele, ans);
            ele.removeLast();
        }
    }
}
