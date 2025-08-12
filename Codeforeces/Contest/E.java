import java.util.*;
public class E{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringBuilder st = new StringBuilder();
        int t = sc.nextInt();
        for(int x = 0; x < t; x++){
            long n = sc.nextLong();
            long[] ar1 = new long[(int)n];
            long[] ar2 = new long[(int)n];

            for(int i = 0; i < n; i++){
                ar1[i] = sc.nextLong();
            }
            for(int i = 0; i < n; i++){
                ar2[i] = sc.nextLong();


            }

            long[] dp = new long[(int)n];
            while(!Arrays.equals(ar1, ar2)){
                boolean op = false;
                for(int i = 0; i < n - 1; i++){
                    if(ar1[i] != ar2[i]){
                        if(dp[i] != 0){
                            st.append("NO\n");
                            break;
                        }
                        else{
                            long temp = ar1[i] ^ ar1[i + 1];
                            if(ar2[i] == temp){
                                ar1[i] = temp;
                                dp[i] = 1;
                                op = true;
                            }
                        }

                    }
                }

                if(!op){
                    st.append("NO\n");
                    break;
                }
            }
            if(Arrays.equals(ar1, ar2)) st.append("YES\n");

        }
        System.out.println(st);


    }
}