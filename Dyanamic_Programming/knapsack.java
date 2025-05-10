import java.util.*;
public class knapsack{

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {3, 4, 4};
        System.out.println(Possible(val, wt, 3, 10));
    }
    public static int Possible(int[] val, int[] wt, int n, int w){
        int[][] t = new int[n + 1][w + 1];

        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < w+1; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < w + 1; j++){
                if(wt[i - 1] <= j){
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < w+1; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }

        return t[n][w];
    }

}