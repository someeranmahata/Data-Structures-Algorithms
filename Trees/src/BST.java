public class BST {

    public BST(){

    }
    public class Node{

        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int val){
            this.value = val;
        }

        public int getValue(){
            return value;
        }
    }
    private Node root;

    private int height(Node node){
        if (node == null){
            return -1;}
        return node.height;
    }


    public boolean isEmpty(){
        return (root == null);
    }

    public void populate(int[] arr){
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);

        }
    }
    public void insert(int val){
        root = insert(val, root);
    }
    private Node insert(int val, Node node){
        if (node == null){
            node = new Node(val);
            return node;
        }
        if (val < node.getValue()){
            node.left = insert(val, node.left);
        }
        if (val > node.getValue()){
            node.right = insert(val, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }


}
