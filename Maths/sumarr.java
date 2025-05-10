import java.util.Arrays;

public class sumarr {
    public static void main(String[] args) {
        int[] arr = {9};
        int[] ans = plusOne(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] plusOne(int[] digits) {
        int ans = Sum(digits) + 1;
        System.out.println(ans);
        if (digits[digits.length-1] == 9)
        {
            int[] digits1 = new int[digits.length+1];
            for (int i = digits1.length-1; i >=0; i--){
                digits1[i] = ans % 10;
                ans = ans/10;
            }
            return digits1;
        }
        else{
            for (int i = digits.length-1; i >=0; i--){
                digits[i] = ans % 10;
                ans = ans/10;
                return digits;
            }
        }
        return digits;
    }
    static int Sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum*10 + arr[i];
        }
        return sum;
    }

}
