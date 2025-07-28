package Codeforeces;
import java.util.*;
public class PracticeTwoPointer_B{
	
	public static void check(int[] first, int[] sec, int m, int n){
		int[] ans = new int[n];
		for(int i = 0; i < n; i++){
			int temp = 0;
			for(int j : first){
				if(sec[i] > j)
					temp++;
				else{
					break;
				}
			}
			ans[i] = temp;
		}
		for(int i : ans){
			System.out.print(i + " ");
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
		
		check(first, sec, m, n);
	}
}