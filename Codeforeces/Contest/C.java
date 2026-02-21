

import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class C {

    static int mod = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        int test = sc.nextInt();
        while(test-- > 0){

            int n = sc.nextInt();
            long[] ar = new long[n];

            for(int i = 0; i < n; i++)
                ar[i] = sc.nextLong();

            if(check(ar))
                st.append(-1).append("\n");
            else{

            }
        }

        System.out.print(st);
    }
    static boolean check(long[] ar){
        long[] temp = ar.clone();
        Arrays.sort(temp);

        return ar.equals(temp);
    }


}