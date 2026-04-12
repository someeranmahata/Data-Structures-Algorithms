import java.util.*;
class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        
        int n = sc.nextInt();
        long k = sc.nextLong();

        long[] ar = new long[n + 1];
        
        for(int i = 0; i <= n ;i++)
            ar[i] = sc.nextLong();

        int prev = 0;
        for(int i = 0; i <= n; i++){
           // System.out.println(prev + " " + i);
           // System.out.println(Math.abs(ar[prev] - ar[i]));
            //System.out.println(Math.abs(ar[prev] - ar[i]) >= k);

            if(Math.abs(ar[i] - ar[prev]) >= k){
                st.append(prev + " " + ar[prev] + "\n");
                prev = i;
            }
        }
        if(prev == n)
            st.append(prev + " " + ar[prev] + "\n");
        System.out.println(st);
        

    }
}
