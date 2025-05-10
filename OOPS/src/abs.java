import java.util.Scanner;

abstract class shape{
    abstract void area();
}
class triangle extends shape{
    double leng;
    double hei;
    triangle(double a,double b){
        leng=a;
        hei=b;
    }
    @Override
    void area(){
        System.out.println("Area is: "+0.5*hei*leng);
    }
}
class square extends shape{
    double side;
    square(double a){
        side =a;
    }
    @Override
    void area(){
        System.out.println("Area is: "+side*side);
    }
}
class circle extends shape{
    double r;
    circle(double a){
        r=a;
    }
    @Override
    void area(){
        System.out.println("Area is: "+Math.PI*r*r);
    }
}
public class abs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter length and height");
        triangle obj =new triangle(sc.nextDouble(), sc.nextDouble());
        obj.area();
        System.out.println("Enter side length of square");
        square obj1 = new square(sc.nextDouble());
        obj1.area();
        System.out.println("Enter the radius of circle");
        circle obj2= new circle(sc.nextDouble());
        obj2.area();
    }

}
