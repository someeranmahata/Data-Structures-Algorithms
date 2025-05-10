import java.util.Arrays;
class merge{
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] nums1 = {1,2,3};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        //System.out.println(nums1+nums2);
    }
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        //Adding all the element of nums2 in nums1
        for (int i = 0; i<m; i++){
            nums1[m+i] = nums2[i];
        }
    }
}