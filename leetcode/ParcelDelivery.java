package leetcode;
import java.util.*;

import java.util.*;

public class ParcelDelivery {
    static final int MOD = 1000000007;
    static int ans = 0;

    public static void parcelDelivery(int st,int K, int R, int[] A, int[] Array_N, int[] check) {
        if(st == R) return;
        int[] temp = swap(Array_N, 0, Array_N[st]);
        int[] temp2 = swap(Array_N, Array_N.length - 1, Array_N[st]);
        for(int i = 0; i < temp.length; i++){
            if((temp2[i] == K || temp[i] == K) && i != K - 1){
                if(check[i] == 0) {
                    ans += i;
                    check[i] = 1;
                }
            }
        }
        parcelDelivery(st + 1, K, R, A, temp, check);
        parcelDelivery(st + 1, K, R, A, temp2, check);

    }
    public static int[] swap(int[] ar, int pos, int ele){
        int[] temp = ar.clone();
        if(pos == 0){
            temp[0] = ele;
            int it = 1;
            for(int i = 0; i < ar.length; i++){
                if(ar[i] == ele)
                    continue;
                temp[it] = ar[i];
                it++;
            }
        }
        else{
            temp[ar.length - 1] = ele;
            int it = 0;
            for(int i = 0; i < ar.length - 1; i++){
                if(ar[i] == ele)
                    continue;
                temp[it] = ar[i];
                it++;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int R = sc.nextInt();
        int[] A = new int[R];

        for (int i = 0; i < R; i++) {
            A[i] = sc.nextInt();
        }
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }
        int[] check = new int[N];
        check[K - 1] = 1;
        ans += K - 1;
        parcelDelivery(0,K, R, A,arr, check);

        System.out.println(ans%MOD);
    }
}

