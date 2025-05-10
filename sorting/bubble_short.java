
import java.util.Arrays;

class bubble_short{
    public static void main(String[] args) {
        int[] arr = {5,9,6,3,8,1,4,2,7};
        System.out.println(Arrays.toString(sort(arr)));
    }
    static int[] sort(int[] num){
        for (int i = 0; i<num.length-1; i++){
            for (int j = 1; j <= num.length-i-1; j++){
                if (num[j] < num[j-1]){
                    int temp = num[j];
                    num[j] = num[j-1];
                    num[j-1] = temp;
                
                }
            }
        }
    return num;
    }
}