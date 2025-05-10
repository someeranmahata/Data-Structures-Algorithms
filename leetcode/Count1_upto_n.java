package leetcode;

public class Count1_upto_n {
    public static int countDigitOne(int n) {
        int[] ar = new int[n + 1];
        for(int i = 0; i < n + 1; i++)
            ar[i] = -1;
        //Finding total number of digit 1s upto n
        int sum = 0;
        while(n >= 0){
            if(ar[n] != -1)
                sum += ar[n];
            else{
                int count = 0; int x = n;
                while(x > 0){
                    if(ar[x / 10] != -1)
                    {
                        count+=ar[x / 10];
                        break;
                    }
                    if(x % 10 == 1){
                        count++;
                        ar[x/10] = count;
                    }

                    x /= 10;
                }
                ar[n] = count;
                sum+=ar[n];
            }
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(countDigitOne(13));
    }
}
