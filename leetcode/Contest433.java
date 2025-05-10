package leetcode;

public class Contest433 {
    public static int[] minCosts(int[] cost) {
        int ind = cost.length - 1;
        for(int i = cost.length - 1; i > 0; i--){
            if(ind == 0)
                break;
            if(cost[i] >= cost[i - 1]){
                if(cost[i - 1] < cost[ind]){
                    ind = i - 1;
                    for(int j = i - 1; j < cost.length; j++){
                        cost[j] = cost[i - 1];
                    }
                }
                else{
                    ind = i - 1;
                    for(int j = i - 1; j < ind; j++){
                        cost[j] = cost[i - 1];
                    }

                }
            }
        }
        return cost;
    }
    public static void main(String[] args){
        int[] arr = {7,9,14,13,4,11,9,5,20,9,8,15,15,8};
        int[] ans = minCosts(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
    }

}
