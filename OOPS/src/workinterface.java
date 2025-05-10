import java.util.*;

interface Flyable{
    void fly();
}
interface Swimmable{
    void swim();
}
class Duck implements Flyable, Swimmable{
    String name;
    Duck(String name){
        this.name  = name;
    }
    public void fly(){
        System.out.println("Duck can Swim");
    }
    public void swim(){
        System.out.println("Duck can swim");
    }
    void displayDetails(){
        System.out.println("Name of duck : " + name);
        swim();
        fly();
    }
}
public class workinterface{

    public static void main(String[] args){
           Duck obj = new Duck("Astorn Martin");
           obj.fly();
           obj.swim();
           obj.displayDetails();
    }
}
