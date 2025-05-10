import java.util.Arrays;
import java.util.*;

class Insertion{
    public static void main(String[] args) {
        int[] arr = {3,5,1,4,2};
        int[] ans = Insert(arr);
        System.out.println("Sorted array:"+Arrays.toString(ans));

    }
    static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        for (int i = 0; i< arr.size()-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr.get(j) < arr.get(j-1))
                    swap2(arr, j, j - 1);
                else
                    break;
            }
        }
    }
    static void swap2(ArrayList<Integer> num, int first,int second){
        int temp = num.get(first);
        num.set(first, num.get(second));
        num.set(first, temp);
    }


    static int[] Insert(int[] num){
        for (int i = 0; i< num.length-1; i++){
            for (int j = i+1; j>0; j--){
                if (num[j] < num[j-1])
                    swap(num, j, j-1);
                else 
                    break;
            }
        }
        return num;
    }
    static void swap(int[] num, int first,int second){
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
}