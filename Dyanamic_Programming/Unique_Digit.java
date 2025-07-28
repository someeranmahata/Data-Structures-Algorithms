import java.util.*;
public class Unique_Digit{
	static int countNumbersWithUniqueDigits(int n) {
        if(n == 0)  return 1;
        if(n == 1)  return 10;
        int limit = (int)Math.pow(10, n);
        boolean[] dp = new boolean[limit];
        Arrays.fill(dp, true);
        for(int i = 1; i <= 9; i++){
            dp[i*11] = false;
        }
        int count = 11;
        for(int i = 11; i < limit ; i++){
            if(!dp[i]) continue;
            boolean temp = check(i, dp);
            if(temp)
                count++;
            dp[i] = temp;
        }
        return count;
    }
    static boolean check(int n, boolean[] dp){
        List<Integer> list = new ArrayList<>();
        boolean temp;
        while(n > 0){
            if(dp[n] == false)
                return false;
            else{
                int last = n % 10;
                if(list.contains(last))
                    return false;
                list.add(last);
                n = n/10;
            }
        }
        return true;  
    }
    public static void main(String[] args){
        System.out.println(countNumbersWithUniqueDigits(8));
    }
}