package Dyanamic_Programming;

public class FlightMincost {
    public static void main(String[] args) {
        int[][] ar = {{3,4,2},{1,2,1},{4,2,1},{0,1,5},{0,2,12},{3,2,1},{1,3,1}};
        System.out.println(findCheapestPrice(10, ar, 0, 2, 3));
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return solve(flights, src, dst, k, 0);
    }
    public static int solve(int[][] flights, int src, int dst, int k, int cost){
        if(src == dst)  return cost;
        if(k < 0) return Integer.MAX_VALUE;

        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < flights.length; i++){
            if(flights[i][0] == src && flights[i][2] != 0){
                int temp = flights[i][2];
                flights[i][2] = 0;
                sum = Math.min(sum, solve(flights, flights[i][1], dst, k - 1, cost + temp));
                flights[i][2] = temp;
            }
        }
        return sum == Integer.MAX_VALUE? -1 : sum;

    }
}
