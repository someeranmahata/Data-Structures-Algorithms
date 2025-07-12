package leetcode;
import java.util.*;
public class Dominoes {
    public static int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        String s = "0";
        return solve(s, n - 1, k);
    }
    public static int solve(String s, int n, int k){
        if(n == 0){
            System.out.println(s);
            return Integer.parseInt("" + s.charAt(k - 1));
        }
        String updated = "";
        for(int i = 0; i < s.length(); i++){
            updated += s.charAt(i) == 0? "01" : "10";
        }
        return solve(updated, n - 1, k);
    }
    public static void main(String[] args) {
        System.out.println(kthGrammar(2,1));
        System.out.println(kthGrammar(2,2));
    }
}
