import java.util.*;

/*
Write a program to represent a given graph (directed / undirected) in adjacency matrix form and adjacency list form.
*/

public class Ques1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<LinkedList<Edge>> adjList = new ArrayList<>();
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			LinkedList<Edge> temp = new LinkedList<>();
			adjList.add(temp);
		}
		while(n-- > 0){
			int from = sc.nextInt();
			int to = sc.nextInt();
			int wt = sc.nextInt();

			Edge edge = new Edge();
			edge.set(from, to, wt);

			adjList.get(from - 1).add(edge);
		}
		System.out.println(adjList);
	}
	
}
public class Edge{
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

