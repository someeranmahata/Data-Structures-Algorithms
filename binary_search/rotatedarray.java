class rotatedarray{
    public static void main(String[] args) {
        int[] arr = {7,8,9,0,1,2,3,4,5,6};
        int ans = findpivot(arr);
        System.out.println("the pivot is at index:"+ans);
        int target = 7;
        boolean search = Binaryreturn(arr, target);
        //System.out.println(search);
    }
    static boolean Binaryreturn(int[] nums, int target){
        int res = findpivot(nums);
        int start = 0;
        int end = nums.length-1;
        //checking whether the number is present in the array or not
        if (target > nums[res])
            return false;
       
        else if(target == nums[res])
            return true;

        else if (target >= nums[start])    //when target is greater than
        {   end = res;              //0 index number
            
            while (start <= end){
                int mid = start + (end-start)/2;
                if (target > nums[mid]){
                    start = mid+1;
                }
                else if(target < nums[mid]){
                    end = mid-1;
                }
                else{
                    return true;
                }
            }
        }
        
        else{       //when target is less than the last index element
            start = res;
            while (start <= end){
                int mid = start + (end-start)/2;
                if (target > nums[mid]){
                    start = mid+1;
                }
                else if(target < nums[mid]){
                    end = mid-1;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
    static int findpivot(int[] nums){   //Finding pivot
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (mid<end && nums[mid] > nums[mid+1])
                return mid;
            if (mid>start && nums[mid] < nums[mid-1])
                return mid-1;
            if (nums[mid] > nums[start])
                start = mid+1;
            else if(mid == end){
                return nums[mid];
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}