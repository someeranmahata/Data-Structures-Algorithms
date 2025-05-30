public class stackLinkedListImplementation {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static class stackLL{
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
            System.out.println(temp.val);
            return temp.val;
        }
        //display
        void display(){
            if(isEmpty()){
                System.out.println("Stack under flow");
                return;
            }
            Node temp = head;
            while(temp != null){
               System.out.print(temp.val + " ");
               temp = temp.next;
            }
            System.out.println();
        }
        boolean isEmpty(){
            return size == 0;
        }

    }
    public static void main(String [] ags){
        stackLL stack = new stackLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        stack.pop();
        stack.display();


    }
}
