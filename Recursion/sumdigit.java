//Adding all the digit of the number using recursion
public class sumdigit{
    public static void main(String[] args){
        int n = 235;
        int ans = 0;
        int s = Sum(n, ans);
        
        System.out.println(s);
    }
    static int Sum(int num, int ans){
        
        if (num == 0)
            return ans;
        
        ans = ans + (num % 10);
        num = num / 10;
        
        return Sum(num, ans);
    }
}