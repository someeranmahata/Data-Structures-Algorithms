public class FindingBinary {
    static int BinaryNumber(int n, int ans){
        if(n <= 0)
            return reverse(ans);
        ans = ans*10 + (n & 1);
        n = n >> 1;
        return BinaryNumber(n, ans);
    }
    static int reverse(int num){
        int x = 0;
        while(num > 0){
            x = x*10 + num % 10;
            num /= 10;
        }
        return x;
    }
    public static void main(String[] args){
        System.out.println(BinaryNumber(19, 0));
    }
}
