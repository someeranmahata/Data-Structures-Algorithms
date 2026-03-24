import java.util.*;

/*
Write a program to traverse a given graph (directed / undirected) using the BFS algorithm.
*/
public class Ques3{
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
		bfs(node, adjList);
	}
	static void bfs(int node, List<LinkedList<Edge>> list){
		System.out.print("bfs traversal : ");
		Queue<Integer> qq = new LinkedList<>();
		boolean[] mark = new boolean[list.size()];

		qq.add(node);
		while(!qq.isEmpty()){
			int ele = qq.poll();
			if(!mark[ele - 1]){
				for(Edge edge : list.get(ele - 1)){
					qq.add(edge.to);
				}
			}
			mark[ele - 1] = true;
			System.out.print(ele + " ");
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

