package Codeforeces;
import java.util.*;
public class ProblemeticPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ans = new int[t];
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int e = sc.nextInt();
            int k = sc.nextInt();

            //taking edges input
            int[][] edges = new int[e][2];
            for(int j = 0; j < e; j++){
                edges[j][0] = sc.nextInt();
                edges[j][1] = sc.nextInt();
            }
            //Storing invalid paths
            HashMap<String, Integer> hm = new HashMap<>();
            int temp = 0;
            for(int j = 1; j <= k; j++){
                temp = sc.nextInt();
                String s = "";
                for(int cur = 0; cur < temp; cur++){
                    s += sc.nextInt();
                }
                hm.put(s, j);
            }
            System.out.println("complete");
            ans[i] = solve(n, edges, hm, temp);
        }
    }
    public static int solve(int n, int[][] path, HashMap<String, Integer> hm, int invalidlen){
        return -1;
    }
}
