package Dyanamic_Programming;
import java.util.*;
public class booleanparenthesization {

    //finding the number of ways to get true/false using operator given by user
    static int solve(String s, int i, int j, boolean istrue){
        if(i > j)
            return 0;
        if(i == j){
            boolean temp = s.charAt(i) == 'T';
            if(istrue == temp)
                return 1;
            else return 0;
        }
        int ans = 0;
        for(int k = i+1; k <= j - 1; k++){
            int lt = solve(s, i, k - 1, true);
            int lf = solve(s, i, k - 1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);

            if(s.charAt(k) == '&'){
                if(istrue)
                    ans = ans + lt * rt;
                else ans = ans + (lt * rf) + (lf * rt) + (lf*rf);
            }
            if(s.charAt(k) == '|'){
                if(istrue)
                    ans += (lt*rf) + (rt*lf) + (lt*rt);
                else ans+= (lf*rf);
            }
            if(s.charAt(k) == '^'){
                if(istrue)
                    ans += (lt*rf) + (lf*rt);
                else ans += lt*rt + lf*rf;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        String s = "T&F&T|T";
        System.out.println((int)'0');
        System.out.println(solve(s,0,s.length() - 1,true));
    }
}
