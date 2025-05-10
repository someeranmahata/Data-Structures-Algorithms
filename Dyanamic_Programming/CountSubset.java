
package Dyanamic_Programming;
import java.util.*;
public class CountSubset {

    public static int Countset(int[] nums, int sum){
        int n = nums.length;
        int[][] t = new int[n + 1][sum +  1];

        for(int i = 0; i <=  n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(nums[i - 1] <= j){
                    t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]];
                }
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }

        return t[n][sum];
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        System.out.println(Countset(nums, 6));
    }
}
