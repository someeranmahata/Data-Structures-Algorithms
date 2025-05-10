import java.util.*;
class BinaryTree {

    public BinaryTree(){

    }
    public class Node{

        int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
        }
        public int getValue(){
            return value;
        }
    }

    private Node root;

    //Inserting value inside a tree to both side right and left
    //If value greater than root then in right side else adding node in left side

    public void insert(Scanner scanner){

        System.out.println("Enter the first Node :");
        int val = scanner.nextInt();

        root = new Node(val);
        insert(scanner, root);
    }
    private void insert(Scanner scanner, Node node){

        System.out.println("Do you want to enter the value to the left of " + node.value);
        boolean left = scanner.nextBoolean();

        if (left){
            System.out.println("Enter the value you want to enter :");
            int val = scanner.nextInt();
            node.left = new Node(val);
            insert(scanner, node.left);
        }

        System.out.println("Do you want to enter the value to the right of " + node.value);
        boolean right = scanner.nextBoolean();

        if (right){
            System.out.println("Enter the value you want to enter :");
            int val = scanner.nextInt();
            node.right = new Node(val);
            insert(scanner, node.right);
        }

    }
    public void display(){
        display(this.root, "-->");
    }
    private void display(Node node , String indent){
        if (node == null)
            return;

        System.out.print(node.value + indent);
        display(node.left, indent);
        display(node.right, indent );


    }

}
