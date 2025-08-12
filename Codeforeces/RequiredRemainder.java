import java.util.*;
public class RequiredRemainder{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		long[] ans = new long[sc.nextInt()];

		for(int i = 0; i < ans.length; i++){

			long x = sc.nextInt();
			long y = sc.nextInt();
			long n = sc.nextInt();

			if(x < y) continue;
			if(n % x == y)
				ans[i] = n;
			else if(n % x < y){
				ans[i] = x * (n / x - 1) + y;
				
			}
			else{
				ans[i] = n - (n % x - y);
			}
		}
		for(long i : ans){
			System.out.println(i);
		}
	}
}