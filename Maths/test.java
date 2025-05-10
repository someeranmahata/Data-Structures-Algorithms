import java.lang.reflect.Array;
import java.util.*;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ar = {4,2,1,5,3};
        int[] ar2 = {10,20,30,40,50};
        long[] ans = findMaxSum(ar, ar2, 2);
        for(long i: ans)
            System.out.print(i + " ");


    }
    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] ans = new long[n];

        //finding the numbers which are less then ith element

        for(int i = 0; i < n; i++){
            String ind = "";
            for(int j = 0; j < n; j++){
                if(nums1[i] > nums1[j])
                    ind += j;
            }
            //creating array consisting those elements from indices of nums2
            int l = ind.length();
            long[] ar = new long[l];
            for(int a = 0; a < l; a++){
                ar[a] = nums2[Integer.parseInt("" + ind.charAt(a))];
            }
            Arrays.sort(ar);
            long sum = 0;
            int ct = k;
            for(int x = l -1; x >=0 && ct!= 0; x--){
                sum+=ar[x];
                ct--;
            }
            //inserting the maximum sum
            ans[i] = sum;
        }
        return ans;
    }


}
