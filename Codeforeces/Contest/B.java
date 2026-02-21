
import com.sun.source.tree.UsesTree;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B {

    static int mod = 1_000_000_007;
    // GRAY CODE = i ^ (i >> 1)
    // way to find whether a number is power of 2 (n & (n - 1)) == 0

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        /*
         */

        int test = sc.nextInt();
        while(test-- > 0){

            int w = sc.nextInt();
            int d = sc.nextInt();
            int temp1 = w;
            int temp2 = d;

            int layer = 0;
            int turn = 1;
            int count = 0;
            while(true){
                int k = 1 << layer;
                if(turn == 1){
                    if(w < k)
                        break;
                    w -= k;
                    count++;
                    turn = 2;
                }
                else{
                    if(d < k)
                        break;
                    d -= k;
                    count++;
                    turn = 1;
                }
                layer++;
            }
            int ans = count;

            turn = 2;
            layer = 0;
            count = 0;
            w = temp1;
            d = temp2;
            while(true){
                int k = 1 << layer;
                if(turn == 1){
                    if(w < k)
                        break;
                    w -= k;
                    count++;
                    turn = 2;
                }
                else{
                    if(d < k)
                        break;
                    d -= k;
                    count++;
                    turn = 1;
                }
                layer++;
            }

            st.append(Math.max(count, ans)).append("\n");

        }

        System.out.println(st);


    }

}