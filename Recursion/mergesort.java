import java.util.Arrays;
//Merge sort
//Dividing the array into two parts and sorting each one of them , and merging them to a single array

public class mergesort {
    public static void main(String[] args){
        int[] arr = {10,100,40,20,50,30,70,90,80,60};
        int[] ans = Mergesort(arr);
        System.out.println("Sorted array:" + Arrays.toString(ans));
    }
    static int[] Mergesort(int[] nums){
        if (nums.length == 1){
           return nums;
        }
        int mid = (nums.length) / 2;
        int[] first = Mergesort(Arrays.copyOfRange(nums, 0, mid));

        int[] second = Mergesort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(first, second);
    }
    static int[] merge(int[] first, int[] second) {

        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        // Till one of the array complete adding its all element
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        //when the element of any array completed
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}
