public class FindingGCD {
    public static void main(String[] args) {
        System.out.println(GCD(38,17, 17));
        System.out.println(GCD(28, 12, 12));
        System.out.println(GCD(64, 18, 18));
    }
    static int GCD(int num1, int num2, int num){
        if(num1 % num == 0 && num2 % num == 0)
            return num;
        return GCD(num1, num2, num - 1);
    }
}
