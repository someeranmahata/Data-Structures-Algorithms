import java.util.*;
public class Reversing {
    public static int reverse(int num, int ans) {
        if(num <= 0)
            return ans;
        ans = ans*10 + num%10;
        return reverse(num/10, ans);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no");
        int num = sc.nextInt();
        int n=reverse(num, 0);
        System.out.println("reverse "+n);
    }

}
