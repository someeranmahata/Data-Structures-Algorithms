class duplicate_num{
    public static int findDuplicate(int[] nums){
            for (int i = 1; i<nums.length; i++){
            int c = 0;
            for (int j = 0; j<nums.length; j++){
                if (nums[j]==i)
                    c++;
                if(c>1)
                    return i;
            }
            c = 0;
        }
    return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4};
        int a = findDuplicate(arr);
        System.out.println(a);
    }
}