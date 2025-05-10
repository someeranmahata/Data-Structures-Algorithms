//Recursion
public class reverse{
    public static void main(String[] args){
        int n = 1234;
        int ans = 0;
        int rev = Reverse(n, ans);
        System.out.println(rev);
    }
    static int Reverse(int num, int ans){
        
        if (num == 0)
            return ans;
        
        ans = (ans*10) + (num % 10);
        num = num / 10;
        return Reverse(num, ans);

    }
}