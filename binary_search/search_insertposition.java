/*
Given a sorted array of distinct integers and a target value, return the index if the
target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
 */ 
class search_insertposition{
    public static int searchInsert(int[] nums, int target){
        int last  = nums.length-1;
        int start = 0;
        int mid = (start+last)/2;
        
        
        do{
            if (target < nums[mid])
                last = mid-1;
            else if(target > nums[mid])
                start = mid+1;
            else{
                return mid;
            }
            mid = (start+last)/2;
        }
        while (nums[start]<=nums[last]);
        return start;
    
    }
    public static void main(String[] args){
        int[] arr = {2,3,5,8,9,12,24,58};
        int target = 10;
        int ans = searchInsert(arr, target);
        System.out.println(ans);
    }
}