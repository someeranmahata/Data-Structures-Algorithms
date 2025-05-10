import java.util.*;
public class Pyq {
    public static void main(String[] args){
        data();
    }
    static void data(){
        Scanner sc = new Scanner(System.in);
        Run ob = new Run();
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i < 2; i++){
            System.out.println("Enter the name and distance covered : ");
            String name = sc.next();
            double dist= sc.nextDouble();
            if(dist > temp)
                ob.setData(name, dist);
        }
        ob.display();
    }
}
class Run{
    String name;
    double distance;
    void setData(String name, double distance){
        this.name = name;
        this.distance = distance;
    }
    void display(){
        System.out.println("Name of the runner : " + name);
        System.out.println("Distance covered : " + distance);
    }
}
