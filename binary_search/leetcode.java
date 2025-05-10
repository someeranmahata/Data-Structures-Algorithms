/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be 
if it were inserted in order.You must write an algorithm with O(log n) runtime complexity.*/
class leetcode {
    public static int searchInsert(int[] nums, int target) {
        int last = nums.length-1;
        int start = 0;
        int mid = last/2;
        int result = -1;
        
        while (nums[start]<nums[last]){
            if (target<nums[mid]){
                last = mid;
            }
            else if (target>nums[mid]){
                start = mid;
            }
            else{
                result = mid;
                return result;
            }
            mid = (start + last)/2;
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,0};
        int target = 8;
        int a = searchInsert(arr, target);
        System.out.println(a);
    }
}