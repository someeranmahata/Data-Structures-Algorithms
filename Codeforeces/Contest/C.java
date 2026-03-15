

import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class C {

    static int mod = 1_000_000_007;
    static double ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        /*
        * dp?
        * dp[i] will store the maximum */

        int test = sc.nextInt();
        while(test-- > 0){

            int n = sc.nextInt();
            double[] c = new double[n];
            double[] p = new double[n];

            for(int i = 0; i < n; i++){
                c[i] = sc.nextInt();
                p[i] = sc.nextInt();
            }



            double curr = 0;
            ans = Integer.MIN_VALUE;
//            solve(0, 1, c, p, curr);
//            double[][] dp = new double[n + 1][n + 1];

            st.append(solve2(n, c, p)).append("\n");


        }

        System.out.print(st);
    }

    static double solve2(int n,  double[] c, double[] p){

        double[] factor = new double[n];
        for(int i = 0; i < n; i++)
            factor[i] = snew(p[i], 1);

        double[] dp = new double[n + 1];
        for(int i = n - 1; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], factor[i] * dp[i + 1] + c[i]);
        }

        return dp[0];

    }

    static double eval(double c, double s){
        return s*c;
    }
    static double snew(double p, double s){
        double temp = s;
        temp -= (s*p)/(double)100;
        return temp;
    }
    //Exaustive search
    static void solve(int i , double s, double[] c, double[] p, double curr){

        if(i == c.length){
            ans = Math.max(curr, ans);
            return;
        }
        //include
        double temp = s;
        temp -= (s*p[i])/(double)100;
        solve(i + 1, temp, c, p, curr + s*c[i]);
        solve(i + 1, s, c, p, curr);

    }


}