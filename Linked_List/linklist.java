
public class linklist {

    private Node head;
    private Node tail;
    private int size;

    public linklist() {
        this.size = 0;
    }

    private class Node {

        private int val;
        private Node next;

        Node(int data) {
            this.val = data;
            this.next = null;
        }

        Node(int data, Node nextval) {
            this.val = data;
            this.next = nextval;
        }

    }

    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + "-> ");
            temp = temp.next;
        }
        System.out.println("NULL");

    }

    // function to get the element of any index
    public Node get(int index) {
        int count = 0;
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //Index of any element
    public int getIndex(int data) {
        int count = 0;
        Node temp = head;
        while (temp.val != data) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    //Insertion of element
    public void firstInsert(int data) {

        Node node = new Node(data);

        node.next = head;       //placing the previous head to next index
        head = node;            //changing the head which is the new added node

        if (tail == null)
            tail = head;

        size++;
    }

    public void insertAt(int data, int pos) {

        Node temp = head;
        System.out.println(head.val);
        while (pos != 1) {
            temp = temp.next;
            pos--;
        }
        System.out.println(temp.val);
        Node value = temp.next;
        temp.val = data;

    }

    //deletion of Nodes
    public int deleteFist() {
        int data = head.val;
        head = head.next;

        if (head == null)
            tail = null;
        size--;
        return data;
    }

    public int deleteLast() {
        if (size <= 1)
            return deleteFist();

        Node secondlast = get(size - 2);
        int data = secondlast.val;
        tail = secondlast;
        tail.next = null;
        return data;
    }

    public int delete(int data) {
        int index = getIndex(data);
        int node = get(index).val;

        if (index == 0)
            return deleteFist();
        if (index == (size - 1))
            return deleteLast();

        Node prev_node = get(index - 1);
        Node next_node = get(index + 1);
        prev_node.next = next_node;

        size--;
        return node;
    }

    //finding the element from where cylic pattern starts
    public void reorderList(Node head) {

        Node pt1 = head;
        Node pt2 = pt1.next;

        Node tail_prev = head;
        while (tail_prev.next.next != null) {
            tail_prev = tail_prev.next;
        }
        System.out.println("tail" + tail_prev.val);

        while (pt1.val != tail_prev.next.val) {

            Node temp = tail_prev.next;
            temp.next = pt2;
            pt1.next = temp;
            System.out.println("updated");

            tail_prev.next = null;
            tail_prev = head;

            while (tail_prev.next.next != null) {
                tail_prev = tail_prev.next;
            }
            System.out.println("tail" + tail_prev.val);

            pt1 = pt2;
            pt2 = pt2.next;
            System.out.println("pt1,pt2" + pt1.val + "," + pt2.val);
        }
    }

}