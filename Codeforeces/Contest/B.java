import java.util.*;
public class B{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
 
        StringBuilder st = new StringBuilder();
        int t = sc.nextInt();
        for(int x = 0; x < t; x++){
            long n = sc.nextLong();
 
            boolean even = n % 2 == 0? true : false;
 
            long countodd = even? n/2 : n/2 + 1;
            countodd = -1 * countodd;
            
            long[] ar = new long[(int)n/2];
 
            while(countodd <= 0){
                for(int i = 0; i < ar.length; i++){
                    ar[i] += 1;
                    countodd++;
                    if(countodd > 0)
                        break;
                }
            }
            Arrays.sort(ar);
            int ind = 0;
            for(int i = 0; i < n; i++){
                if(i % 2 != 0){
                    st.append(ar[ind++] + " ");
                }
                else{
                    st.append(-1 + " ");
                }
            }            
            st.append("\n");
        }
        System.out.println(st);
	}
}