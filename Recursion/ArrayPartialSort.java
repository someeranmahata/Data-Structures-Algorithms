import java.util.*;
public class ArrayPartialSort {
    static int[] sortArray(int[] arr, int k, int f, int l, int pos, int[] ans){
        if(f > l)
            return ans;
        if(arr[pos] <= k){
            ans[f] = arr[pos];
            return sortArray(arr, k, f + 1, l, pos + 1, ans);
        }
        else{
            ans[l] = arr[pos];
            return sortArray(arr, k, f, l - 1, pos + 1, ans);
        }
    }
    public static void main(String[] args) {
        int[] arr= {2,1,5,3,8,4,7,6};
        int[] temp = new int[arr.length];
        int[] ans = sortArray(arr, 5,0, arr.length - 1, 0, temp);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
