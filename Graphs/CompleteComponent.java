import java.util.*;
class CompleteComponent{
    public static void main(String[] args) {
        
    }
    public int countCompleteComponents(int n, int[][] edges) {
        /*
        array for n nodes
        marks the nodes that are visited
        itereate thorugh edges n times if that node is not visited
        */
        int m = edges.length;
        int[] node = new int[n];
        int comp = 0;
        for(int i = 0; i < n; i++){
            
            if(node[i] == 0){
                //find all the possible connected nodes
                Stack<Integer> vertex = new Stack<>();
                vertex.push(i);
                int edgecount = 0; 
                /*
                    counting the number of edge to find if the current component
                    has m*(m - 1)/2 edges
                */
                int distinct_node = 0;
                while(!vertex.isEmpty()){
                    int point = vertex.pop();

                    if(node[point] == 1)
                        continue;
                    distinct_node++;
                    for(int j = 0; j < m; j++){
                        //avoid counting the edge if both the node in edge is already visited
                        if(edges[j][0] == point && node[edges[j][1]] != 1){
                            edgecount++;
                            vertex.push(edges[j][1]);
                        }
                        if(edges[j][1] == point && node[edges[j][0]] != 1){
                            edgecount++;
                            vertex.push(edges[j][0]);
                        }
                    }

                    node[point] = 1;    
                }
                //check if number of edge is equal to m*(m-1)/2
                if((distinct_node * (distinct_node - 1))/2 == edgecount)    
                    comp++;
            }
        }
        return comp;

    }
}