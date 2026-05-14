import java.util.*;
public class IntervalScheduling{

    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       
        List<Interval> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int st = sc.nextInt();
            int end = sc.nextInt();

            Interval temp = new Interval(st, end);
            list.add(temp);
        }

        Collections.sort(list);
        int count = 0;
        int prev = -1;

        List<Interval> ans = new ArrayList<>();
        
        for(int i = 0; i < n ; i++){
            Interval interval = list.get(i);
            if(interval.st >= prev){
                count++;
                ans.add(interval);
                prev = interval.end;
            }
        }
        System.out.println("Total number of non overlapping intervals are : " + count);
        System.out.println("Intervals : \n" + ans);

    }
        
}
class Interval implements Comparable<Interval>{
    int st;
    int end;
    Interval(int st, int end){
        this.st = st;
        this.end = end;
    }
    public int compareTo(Interval sec){
        return Integer.compare(this.end, sec.end);
    }
    public String toString(){
        return ("[" + st + "-" + end + "]");
    }
}
