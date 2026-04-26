
import java.util.*;
public class A{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

        StringBuilder st = new StringBuilder();

        System.out.println(st);
        char[][] grid = {{'a','a','b'}};
        System.out.println(containsCycle(grid));
    }
    static boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]) {
                    if(solve(i, j, -1, -1, grid, visited))
                        return true;
                }
            }
        }
        return false;
    }
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int m, n;
    static boolean solve(int r, int c, int pr, int pc, char[][] grid, boolean[][] visited){
        visited[r][c] = true;

        for(int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                continue;

            if(grid[nr][nc] != grid[r][c])
                continue;

            if(nr == pr && nc == pc)
                continue;

            if(visited[nr][nc])
                return true;

            if(solve(nr, nc, r, c, grid, visited))
                return true;
        }

        return false;
    }
  
}
