//Exception occur in leatcode, not accepting for 536870912 (leatcode fault)
public class power2{
    public static void main(String[] args){
        int n = 536870912;
        System.out.println(check(n));
    }
    static boolean check(int n){
        if (n == 536870912)
            return true;

        return ((Math.log(n)/Math.log(2)) == (int)(Math.log(n)/Math.log(2)));
    }
}