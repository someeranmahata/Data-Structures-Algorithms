package leetcode;

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        System.out.println("--------");
        for(int i = 1; i < m; i++){
            grid[0][i] += grid[0][i - 1];
        }
        for(int j = 1; j < n; j++){
            grid[j][0] += grid[j - 1][0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        return grid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1},{2,8,9},{7,3,2}};
        System.out.println(minPathSum(nums));
    }
}
