package leetcode;
import java.util.*;
public class weekly {
    public static boolean checkDivisibility(int n) {
        if(n == 1) return true;
        int sum = 0;
        int prod = 1;
        int temp = n;
        while(temp > 0){
            int x = temp % 10;
            sum += x;
            prod *= x;
            temp /= 10;
        }
        return n % (sum + prod) == 0;
    }
    public static int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            int ycord = points[i][1];
            hm.put(ycord, hm.getOrDefault(ycord, 0) + 1);
        }
        List<Integer> match = new ArrayList<>();
        for(Integer ele : hm.values()){
            if(ele > 1)
                match.add(ele);
        }
        Collections.sort(match);
        int ans = 0;
        int n = match.size();
        for(int i = n - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0 ; j--){
                ans += (comb(match.get(i)) * comb(match.get(j)));
            }
        }
        return ans;
    }
    public static int comb(int i){
        int a = fact(i);
        int b = 2 * (fact(i - 2));
        return a/b;
    }
    public static int fact(int n){
        if(n == 0) return 1;
        int ans = 1;
        while(n > 1){
            ans *= n;
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(checkDivisibility(99));
        System.out.println(checkDivisibility(23));
        int[][] ar = {{0,0},{1,0},{0,1},{2,1}}




                ;
        System.out.println(countTrapezoids(ar));
    }
}
