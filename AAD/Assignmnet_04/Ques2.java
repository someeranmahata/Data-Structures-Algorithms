import java.util.*;

/*
Write a program to traverse a given graph (directed / undirected) using the DFS algorithm.
*/
public class Ques2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<LinkedList<Edge>> adjList = new ArrayList<>();
		int n = sc.nextInt();
		int e = sc.nextInt();

		int node = sc.nextInt();


		for(int i = 0; i < n; i++){
			LinkedList<Edge> temp = new LinkedList<>();
			adjList.add(temp);
		}
		for(int i = 0; i < e; i++){
			int from = sc.nextInt();
			int to = sc.nextInt();
			int wt = sc.nextInt();

			Edge edge = new Edge();
			edge.set(from, to, wt);

			adjList.get(from - 1).add(edge);
		}
		dfs(node - 1, adjList);
	}
	static void dfs(int node, List<LinkedList<Edge>> list){

		System.out.print("dfs traversal : ");

		Stack<Integer> stack = new Stack<>();
        boolean[] mark = new boolean[list.size()];

        stack.push(node);
        while(!stack.isEmpty()){
            int ele = stack.pop();

            if(!mark[ele]){
                mark[ele] = true;

                System.out.print((ele + 1) + " "); 

                for(Edge edge : list.get(ele)){
                    int v = edge.to - 1;

                    if(!mark[v]){
                        stack.push(v);
                    }
                }
            }
        }

	}
	static void dfs2(int node, List<List<Edge>> list, boolean[] visited){
        visited[node] = true;

        System.out.print((node + 1) + " ");

        for(Edge edge : list.get(node)){
            int v = edge.to - 1;

            if(!visited[v]){
                dfs2(v, list, visited);
            }
        }
    }

}
class Edge{
	int from;
	int to;
	int wt;
	Edge(){
		from = 0;
		to = 0;
		wt = 0;
	}
	void set(int from, int to, int wt){
		this.from = from;
		this.to = to;
		this.wt = wt;
	}
	public String toString(){
		return (from + "->" + to + ", weight : " + wt);
	}
}

