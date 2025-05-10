//GOOD QUES
public class RearrangeBinaryString {
    public static void main(String[] args) {
        String s = "001011";
        int ans = secondsToRemoveOccurrences(s);
        System.out.println(ans);
    }
    static int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (swaping(sb)){
            count++;
        }
        return count;
    }
    static boolean swaping(StringBuilder s){
        boolean ans = false;
        for (int i = 0; i<s.length()-1; i++){
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1'){
                ans = true;
                s.setCharAt(i,'1');
                s.setCharAt(i+1,'0');
                i++;

            }
        }
        return ans;
    }
}
