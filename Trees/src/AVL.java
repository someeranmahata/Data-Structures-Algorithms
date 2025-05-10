public class AVL{
    public AVL(){

    }
    public class Node{
        private int value;
        private int height;
        private Node right;
        private Node left;

        public Node(int val){
            this.value = val;
        }
        public int getValue(){
            return value;
        }

    }
    public int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }

    Node root;
    public void insert(int val){
        root = insert(val, root);
    }
    public void populate(int[] arr){
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }
    }
    private Node insert(int val,Node node){
        if (node == null){
            node = new Node(val);
            return node;
        }
        if(val > node.value)
            node.right = insert(val, node.right);
        if(val < node.value)
            node.left = insert(val, node.left);

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }
    public Node rotate(Node node){
        if (height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0)
            {
                //left-left
                return rightrotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0)
            {
                //left-right
                node.left = leftrotate(node.left);
                return rightrotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0)
            {
                //right-right case
                return leftrotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0)
            {
                //right-left case
                node.right = rightrotate(node.right);
                return leftrotate(node);
            }
        }
        return node;
    }
    private Node rightrotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }
    private Node leftrotate(Node c){
        Node p = c.right;
        Node t = p.left;
        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(p.left), height(p.right) + 1);
        return p;
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