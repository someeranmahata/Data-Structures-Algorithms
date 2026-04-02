import java.util.*;

class Graph{

    /*
     5 7
    1 2 2
    1 3 3
    2 3 1
    2 4 4
    3 4 5
    3 5 6
    4 5 7
     */
    
    List<LinkedList<Edge>> adjList = new ArrayList<>();
    List<Edge> edgeList = new ArrayList<>();
    int V, E;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Graph gp = new Graph();
        gp.construct();        
        gp.kruskalMST();
        gp.primMST(1);
        gp.dijkstra(1);
    }

    void construct(){
        
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        for(int i = 0; i <= V; i++){
        
            adjList.add(new LinkedList<Edge>());
    
        }
        for(int i = 0; i < E; i++){

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            Edge edge = new Edge(u, v, wt);
            adjList.get(u).add(edge);

            Edge edge2 = new Edge(v, u, wt);
            adjList.get(v).add(edge2);
        
            edgeList.add(edge); 
        }

    }

    void kruskalMST(){
        System.out.println("Krushkal's : ");
        List<Edge> ans  = new ArrayList<>();
        Collections.sort(edgeList);
       
        List<List<Integer>> set = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            set.add(temp);
            
        }

        for(Edge edge : edgeList){

            int a = edge.u;
            int b = edge.v;

            int seta = findSet(set, a);
            int setb = findSet(set, b);

            if(seta != setb){

                set.get(seta).addAll(set.get(setb));
                set.remove(setb);

                Edge temp = new Edge(a, b, edge.wt);
                ans.add(temp);

            }

        }
        for(Edge edge : ans)
            System.out.println(edge);


    }
    int findSet(List<List<Integer>> set, int vertex){
        
        for(int i = 0; i < set.size(); i++){
            if(set.get(i).contains(vertex))
                return i;
            
        }
        return vertex;
           
    }
    void primMST(int vertex){
        System.out.println("Prim's : ");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Node> nodeList = new ArrayList<>();
        
        Node zero = new Node(0,0,0);
        nodeList.add(zero);

        for(int i = 1; i <= V; i++){
            if(i == vertex){
                Node node = new Node(i, i, 0);
                pq.add(node);
                nodeList.add(node);
            }
            else{
                Node node = new Node(i, i, Integer.MAX_VALUE);
                pq.add(node);
                nodeList.add(node);
                
            }
        }
        boolean[] visit = new boolean[V + 1];
        while(!pq.isEmpty()){

            Node node = pq.poll();
            int u = node.val;
            if(visit[u])    continue;
            
            System.out.println(node);

            visit[u] = true;
            for(Edge edge : adjList.get(u)){    //adjlist of vertex u
               
                int v = edge.v;
                Node node_v = nodeList.get(v);
                
                if(!visit[v] && (node_v.wt > edge.wt)){
                    Node updatedNode = new Node(v, u, edge.wt);
                    nodeList.set(v, updatedNode);  
                    pq.add(updatedNode);   

                }
                
            }

        }



    }
    void dijkstra(int vertex){

        System.out.println("Shortest distrance from : " + vertex);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Node> nodeList = new ArrayList<>();
        
        Node zero = new Node(0,0,0);
        nodeList.add(zero);

        for(int i = 1; i <= V; i++){
            if(i == vertex){
                Node node = new Node(i, i, 0);
                pq.add(node);
                nodeList.add(node);
            }
            else{
                Node node = new Node(i, i, Integer.MAX_VALUE);
                pq.add(node);
                nodeList.add(node);
                
            }
        }
        boolean[] visit = new boolean[V + 1];
        while(!pq.isEmpty()){

            Node node = pq.poll();
            int u = node.val;
            if(visit[u])    continue;
            
            System.out.println(node);

            visit[u] = true;
            for(Edge edge : adjList.get(u)){    //adjlist of vertex u
               
                int v = edge.v;
                Node node_v = nodeList.get(v);
                
                if(node_v.wt > node.wt + edge.wt){
                    Node updatedNode = new Node(v, u, edge.wt + node.wt);
                    nodeList.set(v, updatedNode);  
                    pq.add(updatedNode);   

                }
                
            }

        }

    }

}
class Node implements Comparable<Node>{

    int par;
    int val;
    int wt;

    Node(int val, int par, int wt){
        this.val = val;
        this.par = par;
        this.wt = wt;
    }
    public int compareTo(Node node){
        return Integer.compare(wt, node.wt);
    }
    public String toString(){
        return("(" + par + "-" + val + " ,wt: "+ wt + ")");
        
    }

}
class Edge implements Comparable<Edge>{

    int u;
    int v;
    int wt;
    Edge(int u, int v, int wt){
        this.v = v;
        this.u = u;
        this.wt = wt;
    }
    public int compareTo(Edge edge){
        return Integer.compare(this.wt, edge.wt);
    }
    public String toString(){
        return ("(" + u + "-" + v + " ,wt: " + wt + ")");

    }
}
