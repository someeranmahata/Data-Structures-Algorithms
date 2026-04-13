import java.util.*;

public class D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        
        /*
           starts with height s and ends to s + m - 1; m = number of dolls
           find consecutive positive integer sequence as much as possible
         */

        int test = sc.nextInt();
        
        while(test-- > 0){
        
            int n = sc.nextInt();
            HashMap<Long, Integer> map = new HashMap<>();
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i = 0; i < n; i++){
                long temp = sc.nextLong();
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                pq.add(temp);
    
            }
            int count = 0;

            while(!pq.isEmpty()){
                long ele = pq.poll();
                if(map.get(ele) == 0)
                    continue;

                while(map.containsKey(ele) && map.get(ele) != 0){
                    map.put(ele, map.get(ele) - 1);
                    ele++;
                }
                count++;
            }
            st.append(count + "\n");
        }
        System.out.println(st);
        
    }

}
           
