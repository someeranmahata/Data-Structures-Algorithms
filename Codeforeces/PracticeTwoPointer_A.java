package Codeforeces;
import java.util.*;
public class PracticeTwoPointer_A{
	public static void solve(int[] first, int[] sec, int m, int n){
		int[] ans = new int[m + n];
		int i = 0;
		int j = 0;
		int cur = 0;
		while(i != m || j != n){
			if(j == n || i < m && first[i] < sec[j]){
				ans[cur] = first[i];
				i++;
			}
			else{
				ans[cur] = sec[j];
				j++;
			}
			cur++;
		}
		for(int ele : ans){
			System.out.print(ele + " ");
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] first = new int[m];
		int[] sec = new int[n];
		for(int i = 0; i < m; i++){
			first[i] = sc.nextInt();
		}
		System.out.println();
		for(int i = 0; i < n; i++){
			sec[i] = sc.nextInt();
		}
		solve(first, sec, m, n);
	}

}
