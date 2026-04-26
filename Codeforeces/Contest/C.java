import java.util.*;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        System.out.println(st);
    }    
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        int e = edges.length;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(new ArrayList<Integer>());
        
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int mask = 1; mask < (1 << n); mask++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0)
                    sum += nums[i];
            }
            if(sum % 2 == 0 && connected(mask, list, n))
                count++;

        }
        return count;

    }
    static boolean connected(int mask, List<List<Integer>> graph, int n) {

        boolean[] visited = new boolean[n];

        int start = -1;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                start = i;
                break;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph.get(node)) {
                if (!visited[nei] && (mask & (1 << nei)) != 0) {
                    visited[nei] = true;
                    q.add(nei);
                    count++;
                }
            }
        }

        int total = Integer.bitCount(mask);

        return count == total;
    }

}

