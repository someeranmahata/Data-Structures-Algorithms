

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
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int min_val = Integer.MAX_VALUE;
            int min_idx = -1;
            for (int i = x; i < y; i++) {
                if (a[i] < min_val) {
                    min_val = a[i];
                    min_idx = i;
                }
            }

            int[] res = new int[n];
            int resIdx = 0;

            int i = 0;
            int j = y;

            while (i < x && a[i] < min_val) {
                res[resIdx++] = a[i++];
            }

            if (i == x) {
                while (j < n && a[j] < min_val) {
                    res[resIdx++] = a[j++];
                }
            }

            for (int ptr = min_idx; ptr < y; ptr++) {
                res[resIdx++] = a[ptr];
            }
            for (int ptr = x; ptr < min_idx; ptr++) {
                res[resIdx++] = a[ptr];
            }

            while (i < x) {
                res[resIdx++] = a[i++];
            }
            while (j < n) {
                res[resIdx++] = a[j++];
            }

            for (int k = 0; k < n; k++) {
                st.append(res[k]).append(k == n - 1 ? "" : " ");
            }
            st.append("\n");
        }

        System.out.print(st);
    }
    static boolean check(long[] ar){
        long[] temp = ar.clone();
        Arrays.sort(temp);

        return ar.equals(temp);
    }


}