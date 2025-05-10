class xoruse{
    //Returning the number whoose dulicate is not present
    public static void main(String[] args) {
        //a^1 = a!
        //a^0 = a
        //a^a = 0
        int[] arr = {2,3,3,4,2,4,6,1,6};
        System.out.println(ans(arr));
    }
    static int ans(int[] nums){
        int unique = 0;
        
        for(int n:nums){
            unique^=n;
        }

        return unique;
    }
}