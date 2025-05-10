public class palin {
    public static void main(String[] args){
        boolean ans = checkpalin(456541);
        System.out.println(ans);
    }
    static boolean checkpalin(int x){
        int num = x;
        int num2  = 0;
        if (x < 0)
            return false;
        while (num != 0){
            num2 = num2*10 + (num%10);
            num = num/10;
        }
        if (x == num2)
            return true;
        return false;

    }
}

