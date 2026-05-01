import java.util.*;
import java.io.*;

public class Main {

    public static String solve(Scanner sc) {
        
        StrinBuilder st = new StringBuilder(st);

        int test = sc.nextInt();
        while(test-- > 0){
                
        }


        System.out.prinltn(st.toString());

    }
    
    
    //METHODS
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long MEX(List<Long> list){
        long min = 0;
        HashSet<Long> set = new HashSet<>(list); // O(1) lookup
        while(true){
            if(set.contains(min)) min++;
            else return min;
        }
    }


    static boolean prime(long x){
        if(x == 1)
            return false;
        else if(x < 3)
            return true;
        for(long i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println(solve(sc));
    }
}
