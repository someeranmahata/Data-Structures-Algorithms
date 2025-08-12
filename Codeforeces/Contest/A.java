import java.util.*;
public class A{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

        StringBuilder st = new StringBuilder();
        int t = sc.nextInt();
        for(int x = 0; x < t; x++){
            int size = sc.nextInt();
            
            int[] a = new int[size];
            int[] b = new int[size];

            for(int i = 0; i < size; i++){
                a[i] = sc.nextInt();
            }
            int big = 0;
            int small = 0;
            for(int i = 0; i < size; i++){
                b[i] = sc.nextInt();
                if(a[i] > b[i])
                    big += a[i] - b[i];
                else if(a[i] < b[i])
                    small += b[i] - a[i];
            }
            
            int count = 1;
            if(big > small){
                count += big;
            }
            else if(big < small){
                count += big;
            }
            else{
                count += big;
            }

            count = count == 0? 1 : count;
            st.append(count + "\n");

        }
        System.out.println(st);
	}
}