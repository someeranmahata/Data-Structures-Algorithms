package leetcode;
import java.util.*;
public class Daily1717 {
    static int ans = Integer.MIN_VALUE;
    public static int maximumGain(String s, int x, int y) {
        if(s.length() == 1) return 0;
        char[] ar = s.toCharArray();
        String first, sec;
        if(y > x){
            int temp = y;
            y = x;
            x = temp;
            first = "ba";
            sec = "ab";
        }
        else{
            first = "ab";
            sec = "ba";
        }
        int cur = 0;
        int count1 = 0, count2 = 0;
        int last = 0;

        while(cur != ar.length){
            if(ar[cur]!= '0'){
                if(last == -1){
                    last = cur;
                }
                else{
                    String temp = "" + s.charAt(last) + s.charAt(cur);
                    if(temp.equals(first)){
                        ar[last] = '0';
                        ar[cur] = '0';
                        last = -1;
                        count1++;
                        if(cur == ar.length - 1)    break;
                        cur = 0;
                        continue;
                    }
                    else{
                        last = cur;
                    }
                }
            }
            cur++;
        }
        //for second
        cur = 0;
        while(cur != ar.length){
            if(ar[cur]!= '0'){
                if(last == -1){
                    last = cur;
                }
                else{
                    String temp = "" + s.charAt(last) + s.charAt(cur);
                    if(temp.equals(sec)){
                        ar[last] = '0';
                        ar[cur] = '0';
                        last = -1;
                        count2++;
                        if(cur == ar.length - 1)    break;
                        cur = 0;
                        continue;
                    }
                    else{
                        last = cur;
                    }
                }
            }
            cur++;
        }
        return count1*x + count2*y;
    }

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        System.out.println(maximumGain(s, 5, 4));

    }
}
