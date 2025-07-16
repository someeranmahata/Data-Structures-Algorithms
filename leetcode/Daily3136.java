package leetcode;
import java.util.*;
public class Daily3136 {
    public static boolean isValid(String word) {
        if(word.length() < 3)
            return false;
        String words = word.toLowerCase();
        boolean vowel = false;
        boolean cons = false;
        for(int i = 0; i < word.length(); i++){
            if(vowel && cons) break;
            char temp = words.charAt(i);
            if(0 + temp <= 122 && 0 + temp >= 97){
                if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
                    vowel = true;
                else
                    cons = true;
            }
        }
        return vowel && cons;
    }

    public static void main(String[] args) {
        System.out.println(isValid("Ya$"));
    }
}
