public class segment{

    public class Node{
        private int endvalue;
        private int startvalue;
        private Node right;
        private Node left;
        private int data;

        public Node(int val1, int val2){
            startvalue = val2;
            endvalue = val2;
        }

    }
    private Node root;

    public segment(int[] arr){
        this.root = construct(arr, 0, arr.length-1);
    }
    public Node construct(int[] arr, int st, int end){
        if (st == end){
            Node leaf = new Node(st, end);
            leaf.data = arr[st];
            return leaf;
        }
        Node node = new Node(st, end);
        int mid = (st + end)/2;

        node.left = construct(arr, st, mid);
        node.right = construct(arr, mid+1,end);

        node.data = node.left.data + node.right.data;
        return node;
    }
    

}
