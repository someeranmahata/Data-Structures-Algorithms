package Work_Hashmaps;
import java.util.*;
public class SubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n;

        int ans = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = i; j < n; j++){
                String temp = s.substring(i, j + 1);
                if(valid(temp))
                    count+=1;
                else
                    break;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static boolean valid(String s){
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            if(hm.containsKey(c)) return false;
            hm.put(c, 1);
        }

        return true;
    }
    public static void main(String[] args){
        System.out.println();
    }
}
