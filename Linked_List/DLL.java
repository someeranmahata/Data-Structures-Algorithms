
public class DLL {

    public static class Node{
        int val;
        Node prev;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    private static Node head = null;
    private static Node tail = null;

    public static void insert(int val){
         Node temp = new Node(val);
         if(head == null){
             head = temp;
             tail = temp;
             return;
         }
         tail.next = temp;
         tail.next.prev = tail;
         tail = tail.next;
    }
    static void display(){
         Node temp = head;
         while(temp != null){
             System.out.println((temp.prev == null? "null" : temp.prev.val) + " -> " + temp.val + " -> " +(temp.next == null? "null" : temp.next.val));
             temp = temp.next;
         }
         Node temp2 = head;
         while(temp2 != null){
             System.out.print(temp2.val + " ");
             temp2 = temp2.next;
         }
         System.out.println();
    }

    public static void main(String[] args) {
        insert( 1);
        insert( 2);
        insert( 3);
        insert( 4);
        insert( 5);
        display();
    }
}
