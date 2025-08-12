package PriorityQueue.Max_heap;
import java.util.*;

public class Power2Maxheap {
    
    private PriorityQueue<Integer> data = new PriorityQueue<>(Collections.reverseOrder());
    private int len = 0;
    private int head = 0;

    public Power2Maxheap(int len) {
        this.len = (int)Math.pow(2, len);
    }

    public void insert(int ele){
        data.add(ele);
        head = data.peek();
    }

    int popMax(){
        len--;
        int temp = data.poll();
        head = data.peek();
        return temp;
    }
    // public static void main(String[] args) {
    //     Power2Maxheap p = new Power2Maxheap(3);
        
    //     int[] ar = {15, 10, 7, 25, 20, 30};
    //     for(int i : ar){
    //         p.insert(i);
    //     }

    //     System.out.println(p.popMax());
    // }
    
}
