public class LongestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        for(int i = 0; i < strs[0].length(); i++){
            int count = 0;
            for(int j = 1; j < strs.length; j++){
                if(i <= strs[j].length() - 1){
                    if(("" + strs[0].charAt(i)).equals("" + strs[j].charAt(i)))
                        count++;
                }
                else
                    return ans;
            }
            if(count == strs.length - 1)
                ans += strs[0].charAt(i);
            count = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] ar = {"andaman","an","andcpi"};
        System.out.println(longestCommonPrefix(ar));
    }
}
