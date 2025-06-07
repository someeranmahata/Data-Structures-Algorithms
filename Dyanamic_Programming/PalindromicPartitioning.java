package Dyanamic_Programming;

//mininmum number of partition in string to make each partitioned term palindrome
public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "Mahata";
        int l  = s.length() - 1;
        System.out.println(solve(s,0, l));
    }
    static int solve(String s,  int st, int end){
        if(st >= end)
            return 0;
        if(isPalindromic(s, st, end))
            return 0;

        int mn = Integer.MAX_VALUE;
        for(int k = st; k <= end - 1; k++){
            int temp = solve(s, st, k) + solve(s, k + 1, end) + 1;
            if(temp < mn)
                mn = temp;
        }
        return mn;
    }

    static boolean isPalindromic(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
