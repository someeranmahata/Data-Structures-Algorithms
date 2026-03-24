import java.util.*;

/*
Write a program to detect whether a directed graph is strongly connected.
*/

/*
4 5
1 2 3
1 3 4
2 3 4
2 4 5
3 4 5

3 3
1 2 3
2 3 4
3 1 2

*/
public class Ques6{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<LinkedList<Edge>> adjList = new ArrayList<>();
		List<LinkedList<Edge>> Grev = new ArrayList<>();
		int n = sc.nextInt();
		int e = sc.nextInt();

		for(int i = 0; i < n; i++){
			LinkedList<Edge> temp = new LinkedList<>();
			adjList.add(temp);
			LinkedList<Edge> temp2 = new LinkedList<>();
			Grev.add(temp2);
		}
		for(int i = 0; i < e; i++){
			int from = sc.nextInt();
			int to = sc.nextInt();
			int wt = sc.nextInt();

			Edge edge = new Edge();
			Edge edge2 = new Edge();

			edge.set(from, to, wt);
			edge2.set(to, from, wt);

			adjList.get(from - 1).add(edge);
			Grev.get(to - 1).add(edge2);
		}
		System.out.println(strongComponent(1, adjList, Grev));
		
	}
	static boolean strongComponent(int start, List<LinkedList<Edge>> list, List<LinkedList<Edge>> Grev){
    	return bfs(start, list) && bfs(start, Grev);
	}
	
	static boolean bfs(int node, List<LinkedList<Edge>> list){

    	Queue<Integer> qq = new LinkedList<>();
    	boolean[] mark = new boolean[list.size()];

    	qq.add(node);
    	mark[node - 1] = true;

    	while(!qq.isEmpty()){
        	int ele = qq.poll();

        	for(Edge edge : list.get(ele - 1)){
            	int v = edge.to;

            	if(!mark[v - 1]){
                	mark[v - 1] = true;
                	qq.add(v);
            	}
        	}
    	}	
    	for(boolean v : mark){
        	if(!v) return false;
    	}

    	return true;
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

