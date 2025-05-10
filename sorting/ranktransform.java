
import java.util.*;

class ranktranform{
    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        String ans = Arrays.toString(arrayRankTransform(arr));
        System.out.println(ans);
    }
    static int[] arrayRankTransform(int[] arr) {
        int[] newarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            newarr[i] = i+1;
        }
        Sort(arr, newarr);
        return newarr;
    }
    static int[] Sort(int[] num,int[] arr){
        for (int i = 0; i< num.length-1; i++){
            for (int j = i+1; j>0; j--){
                if (num[j] < num[j-1])
                    swap(arr, j, j-1);
                else 
                    break;
            }
        }
        return arr;
    }
    static void swap(int[] num, int first,int second){
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
    
}