import java.util.*;
class SalesMan {
    int empid;
    String name;
    double sales;

    SalesMan(int empid, String name, double sales) {
        this.empid = empid;
        this.name = name;
        this.sales = sales;
    }
    double getCommission() {
        if (sales < 500)
            return sales * 0.02;
        else if (sales < 5000)
            return sales * 0.05;
        else
            return sales * 0.08;
    }
}
public class Ques_03 {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);
        SalesMan[] ob = new SalesMan[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Enter the empid, name and sales : ");
            ob[i] = new SalesMan(sc.nextInt(), sc.next(), sc.nextDouble());

        }
        for(int i = 0; i < 5; i++){
            System.out.println("Commission of " + ob[i].name + " is :" + ob[i].getCommission());
        }
    }
}
