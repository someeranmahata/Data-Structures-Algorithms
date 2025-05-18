package Dyanamic_Programming;

class CoinchangeUnbounded {
    static int coinchange(int[] coin, int amount){
        int n = coin.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= amount; j++){
                if(j == 0)
                    dp[i][j] = 0;
                if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        for(int i = 1; i <= amount; i++){
            if(i % coin[0] == 0)
                dp[1][i] = i / coin[0];
            else
                dp[1][i] = Integer.MAX_VALUE - 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coin[i - 1] <= j)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin[i - 1]] + 1);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        //printing the array
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= amount; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[n][amount] != Integer.MAX_VALUE - 1 ? dp[n][amount] : -1;
    }

    public static void main(String[] args) {
        int[] ar = {7,6,4};
        int ans = coinchange(ar, 5);
        System.out.println(ans);
    }
}
