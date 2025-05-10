public class Binarysearch {

    public static void main(String[] args){
        int[] arr = {1,3,5,6,11,19,155,999};
        int tar = 7;
        int ans = searchInsert(arr, tar);
        System.out.println(ans);
    }
    static int searchInsert(int[] nums, int target) {
        int st = 0;
        int end = nums.length-1;
        while (st <= end){
            int mid = st + (end - st)/2;
            if (target > nums[mid])
                st = mid + 1;
            else
                end = mid - 1;
        }
        return st + (end - st)/2;
    }

//    static int searchInsert(int[] nums, int target) {
//        int ans = search(nums, target, 0, nums.length-1, 0);
//        return ans;
//    }
//    static int search(int[] num, int target, int st, int end, int mid){
//
//        if (st > end)
//            return mid;
//        else{
//            mid = st +  (end - st)/2;
//            if (num[mid] == target)
//                return mid;
//            if (target > mid)
//                return search(num, target, mid +1, end, mid);
//            else
//                return search(num, target, st, mid -1, mid);
//        }




//        if (target > num[num.length-1])
//            return num.length;
//
//        int mid = st + (end - st)/2;
//
//        if (st <= end){
//
//            if (num[mid] == target){
//                return mid;
//            }
//
//            if (target < mid){
//                return search(num, target, st, mid-1);
//            }
//
//            else
//                return search(num, target, mid + 1, end);
//        }
//        return mid-1;



}
