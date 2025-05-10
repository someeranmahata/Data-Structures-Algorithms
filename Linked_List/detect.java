public class detect {

    public static void main(String[] args){
        int[] ar1 = {1,2,3,4,5,6,7,8,6};
        int[] ar2 = {1,2,3,4,5,0};
        Node head1 = InsertValue(ar1);
        Node head2 = InsertValue(ar2);
        System.out.println(detectCycle(head2));
        System.out.println(detectCycle(head1));
    }

    public static class Node{
        private Node head;
        private Node next;
        private int val;
        public Node(int data){
            this.val = data;
        }
    }
    public static Node InsertValue(int[] ar){
        Node head = new Node(ar[0]);
        Node dummy = head;
        for(int i = 1; i < ar.length; i++){
            dummy.next = new Node(ar[i]);
            dummy = dummy.next;
        }
        return head;
    }
    public static boolean detectCycle(Node head){
        return check(head, head, head);
    }
    private static boolean check(Node head, Node slow, Node fast){
        if((slow.val == fast.val && slow != head))
            return true;
        if((fast.val == 0 || fast.next.val == 0))
            return false;
        return check(head, slow.next, fast.next.next);
    }

}
