import java.util.*;
public class Knapsack{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double limit = sc.nextInt();

        int[] wt = new int[n];
        for(int i = 0; i < n; i++)
            wt[i] = sc.nextInt();

        List<Item> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            Item item = new Item(i + 1, wt[i], val);
            list.add(item);
        }
        Collections.sort(list);
        System.out.println(list);

        double total = 0;
        int i = 0;
        StringBuilder st = new StringBuilder();

        while(i < n && limit > 0){
            Item item = list.get(i);
            if(item.wt <= limit){
                limit -= item.wt;
                total += item.val;
                st.append("item" + item.itemno + "->" + item + "\n");
            }
            else{
                total += (limit*item.frac);
                st.append("item" + item.itemno + "->" + "(wt : " + limit + ",val : " + limit*item.frac +")" + "\n");
                limit = 0;
            }
            i++;
        }

        System.out.println(total);
        System.out.println(st);
    }

}
class Item implements Comparable<Item>{
    int itemno;
    int wt;
    int val;
    Double frac;
    
    Item(int itemno, int wt, int val){
        this.wt = wt;
        this.val = val;
        this.itemno = itemno;
        frac = ((double)val/(double)wt);
    }
    public int compareTo(Item item){
        Double temp = item.frac;
        return temp.compareTo(this.frac);
    }
    public String toString(){
        return ("(wt : " + wt + ",val : " + val +")");
    }


}

