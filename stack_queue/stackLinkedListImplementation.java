public class stackLinkedListImplementation {
    public class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public class stackLL{
        private Node head = null;
        private int size = 0;

        //push function
        void push(int val){
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            size++;
        }
        //pop function
        int pop(){
            if(isEmpty()){
                System.out.println("Over flow");
                return -1;
            }
            Node temp = head;
            head = head.next;
            size--;
            return temp.val;
        }
        //display
        void display(){
            if(isEmpty())
                return;
            while(head != null){
               System.out.print(head.val + " ");
            }
            System.out.println();
        }
        boolean isEmpty(){
            return size == 0;
        }

    }
}
