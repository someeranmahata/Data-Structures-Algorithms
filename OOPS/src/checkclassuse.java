import java.util.*;
public class checkclassuse{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println(sum(5,5));
        System.out.println(sub(7,4));

    }
    protected static int sum(int x ,int y) {
        return x+y;
    }
    private static int sub(int x, int y){
        return x-y;
    }

}
