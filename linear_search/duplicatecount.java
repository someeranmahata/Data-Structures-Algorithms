
import java.util.Arrays;

class duplicatecount{
    static int removeDuplicates(int[] nums) {
        int pos = 1;
        for (int i = 0; i<=nums.length-1; i++){
            if (i > 0 && nums[i] > nums[i-1])
            {
                nums[pos] = nums[i];
                pos++;
            }
        }
        System.out.println("the arrray is:"+Arrays.toString(nums));
        return pos;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
}