import java.util.*;
public class Huffman{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] ar = new char[n];

        for(int i = 0; i < n; i++){
            ar[i] = sc.next().charAt(0);
        }
        List<Node> list = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            char c = ar[i];
            int temp = sc.nextInt();
            Node node = new Node(c, temp);
            pq.add(node);
        }

        construct(pq);
        String temp = "";
        Node node = pq.poll();
        dfs(node, temp);
    }
    static void dfs(Node node, String code){
        
        char ele = node.c;
        if(ele != '-'){
            System.out.println(ele + " : " + code);
            return; 
        }
        if(node.right != null)  dfs(node.right, code + 1);
        if(node.left != null)   dfs(node.left, code + 0);
    }
    static void construct(PriorityQueue<Node> pq){
        
        while(pq.size() != 1){
           Node a = pq.poll();
           Node b = pq.poll();
            
           Node node = new Node('-', a.val + b.val);
           node.left = a;
           node.right = b;
           pq.add(node);
        }
    }
}

class Node implements Comparable<Node>{
    char c;
    Node left;
    Node right;
    int val;
    
    Node(char c, int val){
        this.c = c;
        this.val = val;
    }

    public int compareTo(Node node){
        return Integer.compare(this.val, node.val);
    }    
    public String toString(){
        return (c + " : " + val);
    }

}
