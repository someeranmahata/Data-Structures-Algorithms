import java.util.*;

/*
Write a program to detect a cycle in an undirected graph using the FIND-UNION data structure.
*/
public class Ques5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<LinkedList<Edge>> adjList = new ArrayList<>();
		int n = sc.nextInt();
		int e = sc.nextInt();

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
		List<Integer> list = new ArrayList<>();

		System.out.println("Enter s and t : ");
		int u = sc.nextInt();
		int v = sc.nextInt();
		
		findPath(u, v, adjList, list);
		
	}
	static void findPath(int s, int t, List<LinkedList<Edge>> list, List<Integer> path){
		path.add(s);

		if(s == t){
    		System.out.println(path);
    		path.remove(path.size() - 1);
    		return;
		}

		for(Edge edge : list.get(s - 1)){
    		if(!path.contains(edge.to)){
        		findPath(edge.to, t, list, path);
    		}
		}

		path.remove(path.size() - 1);
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

