package Dyanamic_Programming;
import java.util.*;
public class subsetSum {

    public static boolean Possible(int[] arr, int sum){
        int n = arr.length;
        boolean[][] result = new boolean[n+1][sum+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0)
                    result[i][j] = false;
                if(j == 0)
                    result[i][j] = true;
            }
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(arr[i - 1] <= j)
                    result[i][j] = result[i][j - arr[i - 1]] || result[i - 1][j];
                else
                    result[i][j] = result[i - 1][j];
            }
        }
        return result[n][sum];
    }


    public static void main(String[] args){
        int[] arr = {10, 3, 7};
        System.out.println(Possible(arr, 4));
    }

}

