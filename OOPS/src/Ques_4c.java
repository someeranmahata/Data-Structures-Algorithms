import java.util.*;
interface Polygon{
    int findArea();
}
class Rectangle123 implements Polygon{
    int l, b;
    Rectangle123(int l, int b){
        this.l = l;
        this.b = b;
    }
    public int findArea(){
        return l*b;
    }
}
class Square123 implements Polygon{
    int a;
    Square123(int a){
        this.a = a;
    }
    public int findArea(){
        return a*a;
    }
}
public class Ques_4c {
    public static void main(String[] args) {
        Square123 obj1 = new Square123(5);
        Rectangle123 obj2 = new Rectangle123(10, 2);
        System.out.println("Area of Square : "+obj1.findArea());
        System.out.println("Area of Rectangle : "+obj2.findArea());

    }
}
