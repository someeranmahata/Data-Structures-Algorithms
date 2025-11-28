import java.util.*;
public class tree{

    tree(int value) {
        head = new Node(value);
    }
    public class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
        public static int getval(Node node){
            return node.val;
        }
    }
    private final Node head;

    public static void BFS(tree t){
        Node root = t.head;
        if(root == null)
            return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.val + " ");

            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        System.out.println();
    }

    public static void DFS(tree t){
        Node root = t.head;
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.val + " ");

            if(temp.left != null)
                stack.push(temp.left);

            if(temp.right != null)
                stack.push(temp.right);
            
        }
        System.out.println();
    }
    public static void main(String[] args) {
        tree t = new tree(1);
        Node temp = t.head;
        temp.left = t.new Node(2);
        temp.left.right =t.new Node(7);
        temp.right = t.new Node(3);
        temp.right.left = t.new Node(4);
        temp.right.left.left = t.new Node(5);
        temp.right.left.right = t.new Node(6);

        System.out.println("DFS");
        DFS(t);
        System.out.println("BFS");
        BFS(t);
        }
    
}