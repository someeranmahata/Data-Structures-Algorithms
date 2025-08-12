import java.util.*;

public class WeeklyC{
    public static int minTime(String s, int[] order, int k) {
        StringBuilder word = new StringBuilder(s);
        int ans = -1;
        for(int i = 0; i < order.length; i++){
            int ind = order[i];
            String temp = word.substring(0, ind) + "*";
            if(ind != word.length() - 1)   temp += word.substring(ind + 1);

            int count = validSubs(temp);
            if(count >= k)  return i;
            word = new StringBuilder(temp);
        }
        return ans;
    }

    public static int validSubs(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            boolean contains = false;
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '*')
                    contains = true;
                if(contains)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ar = {1,0,2};
        System.out.println(minTime("abc", ar, 2));
    }

}