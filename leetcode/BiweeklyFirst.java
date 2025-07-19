package leetcode;

class BiweeklyFirst {
    public static long splitArray(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];

        long sumprime = 0;
        long sum = nums[0];
        for(int i = 1; i < n; i++){
            if(i == 1) {
                sum += nums[i];
            }
            else if(i <= 3) {
                sumprime += nums[i];
            }
            else{
                int j = 2;
                for(j = 2; j <= Math.sqrt(i); j++){
                    if(i % j == 0){
                        sum+= nums[i];
                        break;
                    }
                }
                if(j > Math.sqrt(i)){
                    sumprime += nums[i];
                }
            }
        }
        return Math.abs(sum - sumprime);
    }
    static int ans = Integer.MIN_VALUE;
    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int m = edges.length;
        int n = 0;
        for(int i = 0; i < m; i++){
            n = Math.max(edges[i][0], edges[i][1]);
        }
        solve(edges, online, k, 0, n, Integer.MAX_VALUE);
        return ans == Integer.MAX_VALUE || ans == Integer.MIN_VALUE? -1 : ans;
    }
    public static int solve(int[][] path, boolean[] valid, long k, int st, int end, int tempans){

            if(st == end || k <= 0){
                if(k < 0)return Integer.MAX_VALUE;
                if(st == end && k >= 0){
                    ans = Math.max(tempans, ans);
                    return tempans;
                }
            }


        for(int i = 0; i < path.length; i++){
            if(path[i][0] == st){
                if(i < valid.length && valid[i]){
                tempans = Math.min(path[i][2], tempans);
                solve(path, valid, k - path[i][2], path[i][1], end, tempans);
                if(st == 0) tempans = Integer.MAX_VALUE;
                }
                else{
                    tempans = Math.min(path[i][2], tempans);
                    solve(path, valid, k - path[i][2], path[i][1], end, tempans);
                    if(st == 0) tempans = Integer.MAX_VALUE;
                }


            }
        }
        return tempans;
    }

    public static void main(String[] args) {
        int[] ar = {-1,5,7,0};
        int[][] arr = {{0,1,98}}
                ;
        boolean[] temp = {true,true};
        System.out.println(findMaxPathScore(arr, temp, 12));

    }
}