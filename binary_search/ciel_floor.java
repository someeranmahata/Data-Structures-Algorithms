class ciel_floor{
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9,14,18,25};
        int target = 2;
        int check1 = ciel(arr, target);
        int check2 = floor(arr, target);
        System.out.println(check1);
        System.out.println(check2);
    }
    //method to find the Cieling from an array
    static int ciel(int[] nums, int target){
        int last = nums.length-1;
        int start = 0;
        int mid = (start + last)/2;
        int result = 0;

        while (nums[start]<=nums[last]){
            if (target > nums[mid])
                start = mid+1;
            else if(target < nums[mid])
                last = mid-1;
            else
                {result = mid;
                return result;}
            mid = (start+last)/2;
        }
        return start;
    }
    //method to find the floor of the target fron an array
    static int floor(int[] nums, int target){
        int last = nums.length-1;
        int start = 0;
        int mid = (start + last)/2;
        int result = 0;

        while (nums[start]<=nums[last]){
            if (target > nums[mid])
                start = mid+1;
            else if(target < nums[mid])
                last = mid-1;
            else
                {result = mid;
                return result;}
            mid = (start+last)/2;
        }
        return last;
    }
    
}