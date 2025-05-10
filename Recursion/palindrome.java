import java.util.Arrays;

public class palindrome{
    public static void main(String[] args){
        int[] res = change(1234, 4);
        System.out.println(Arrays.toString(res));
        
    }
    static boolean Check(int num,int l){
        int[] resarr = change(num, l);
        return false;
    }

    //Adding all the digit of number in an array
    
    static int[] change(int num, int l){
        int[] ar = new int[l];
        int ct = 0;
        while ( num != 0){
            ar[ct] = num % 10;
            ct ++;
            num = num/10;
        }
        return ar;
    }
}