import java.util.*;
public class MaximumConnectedComponent {
    /*
    * There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.

A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.

Return the maximum number of components in any valid split.*/
    public static void main(String[] args) {

    }
    public static int[] findParents(int n, int[][] edges) {
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);   // root will remain -1

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);  // start BFS from node 0
        parent[0] = -1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nei : graph.get(curr)) {
                if (parent[nei] == -1 && nei != 0) { // unvisited node
                    parent[nei] = curr;
                    q.offer(nei);
                }
            }
        }

        return parent;
    }
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        /**
         we need to find the maximum number of valid connected components we can form by removing the edges
         such that value sum of component is divisible by k
         Applying dfs and removing and cutting down the edges when the value sum is equal to the multiple of k
         we need to start from the leaf node?
         we need to inser level wise
         */

        int[] par = findParents(n, edges);
        if(n == 1 || k == 1)  return n;
        int comp = 0;

        long[] val = new long[n];
        for(int i = 0; i < n; i++){
            val[i] = values[i];
        }
//        for(int i = 0; i < n; i++){
//            val[i] = val[i] % k;
//        }
        boolean[] mark = new boolean[n];
        Arrays.fill(mark, false);

        Queue<Integer> level = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(par[i] == -1){
                mark[i] = true;
                continue;
            }
            else
                mark[par[i]] = true;
        }
        for(int i = 0; i < n; i++){
            if(!mark[i]){
                level.add(i);
            }
        }
        int count = 0;
        Arrays.fill(mark, false);
        while(!level.isEmpty()){
            int node = level.poll();
            if(mark[node])
                continue;
            if(par[node] == -1 && count != n - 1)
                continue;
            mark[node] = true;
            count++;
            if(val[node] % k == 0){
                comp++;
            }
            else{
                val[par[node]] += (val[node]);
                val[node] = 0;

            }
            int x = par[node];
            if(x == -1)
                continue;
            level.add(x);
        }
        return comp;

    }
}
