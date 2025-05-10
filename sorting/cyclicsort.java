
import java.util.Arrays;

class cyclicsort{
    public static void main(String[] args){
        //Applicable only when all the numbers are present between [1,N]
        int[] arr = {5,2,4,1,3,6};
        System.out.println(Arrays.toString(arr));
        sort2(arr);
        System.out.println(Arrays.toString(arr));
        arr[6] = 88;
        System.out.println(Arrays.toString(arr));


    }
    static void sort2(int[] num){
        int i = 0;
        while (i<num.length){
            int correct = num[i] - 1;
            if (num[i] != num[correct]){
                swap(num, i, correct);
            }
            else {
                i++;
            }
        }
    }
    static int[] sort(int[] num){
        for (int i = 0; i<num.length; i++){
            if (num[i] != i+1)
            {   while(num[i] != i+1)
                    swap(num, i, num[i]-1);
            }
        }
        return num;
    }
    static void swap(int[] a, int ind1, int ind2){
        int temp = a[ind1];
        a[ind1] = a[ind2];
        a[ind2] = temp;
    }
}