import java.util.*;

public class D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        
        /*
         */

        int test = sc.nextInt();
        
        while(test-- > 0){
       
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            
            long count = 0;
            long[] ar = new long[n];
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int i = 0; i < n; i++)
                ar[i] = sc.nextLong();

            for(int i = 0; i < n; i++){

                long a = ar[i]%x;
                long  b = ar[i]%y;
                long c = x-a;
                if (c == x){c = 0;}
                count += map.getOrDefault(c+"_"+b,0);
                map.put(a+"_"+b,map.getOrDefault(a+"_"+b,0)+1);                

            }
                
            



            st.append(count + "\n");

        }

        System.out.println(st);
        
    }

}
           
