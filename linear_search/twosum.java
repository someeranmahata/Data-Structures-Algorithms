class twosum{
    static void twosum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i=0; i<numbers.length; i++){
            for (int j = i+1; j<numbers.length; j++){
                if (numbers[i]+numbers[j]==target){
                    System.out.println(""+i+" "+j);}
            }
    }
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 18;
        //int[] ans = twosum(arr, target);
        //System.out.println(ans);
    }
}   