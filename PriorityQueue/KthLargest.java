package PriorityQueue;
import java.util.*;
public class KthLargest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(5);
        pq.add(10);
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            System.out.print(pq.poll() + " ");
        }
    }
}
