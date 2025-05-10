package leetcode;

public class Climbing_Stairs {
    public static int climbStairs(int n) {
        int[] ar = new int[n+1];
        ar[0] = 1;
        ar[1] = 1;
        for(int i = 2; i < n+1; i++){
            ar[i] = ar[i - 1] + ar[i - 2];
        }
        return ar[n];
    }
    public static void main(String[] args){
        System.out.println(climbStairs(45));
    }
}

