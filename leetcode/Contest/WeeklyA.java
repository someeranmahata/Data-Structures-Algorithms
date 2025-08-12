
public class WeeklyA{
    public static boolean isTrionic(int[] nums) {
        boolean st = false;
        boolean mid = false;
        boolean end = false;
        int i = 0;
        if(! st && nums[i] < nums[i + 1])
        {
            while(i < nums.length - 1 && nums[i] < nums[i + 1]){
                i++;
            }
            st = true;
        }
        if(!st)
            return false;
        if(i < nums.length - 1 && !mid && nums[i] > nums[i + 1]){
            while(i < nums.length - 1 && nums[i] > nums[i + 1]){
                i++;
            }
            mid = true;
        }
        if(!mid)
            return false;
        if(i < nums.length - 1 &&  !end && nums[i] < nums[i + 1]){
            while(i < nums.length - 1 && nums[i] < nums[i + 1]){
                i++;
            }
            if(i == nums.length - 1)
                end = true;
        }
        return st && mid && end;
    }
    public static void main(String[] args) {
        int[] ar = {2,};
        System.out.println(isTrionic(ar));
    }
}