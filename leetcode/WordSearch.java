import java.util.*;
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int[][] path = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(board, path.clone(), word, "", i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean solve(char[][] nums, int[][] path, String word, String ans ,int row, int col){
        if(ans.equals(word)){
            return true;
        }
        boolean temp = false;
        if((!("" + nums[row][col]).equals("" + word.charAt(ans.length())) || path[row][col] != 0) && word.length() != 0) return false;


        if(("" + nums[row][col]).equals("" + word.charAt(ans.length())) && path[row][col] == 0){

            if(("" + nums[row][col]).equals(word))  return true;
            if(row < nums.length - 1){
                int[][] ar = path.clone();
                ar[row][col] = 1;
                temp = temp || solve(nums, ar, word, ans + nums[row][col], row + 1, col);
            }
            if(temp)
                return true;
            if(col < nums[0].length - 1){
                int[][] ar = path.clone();
                ar[row][col] = 1;
                temp = temp || solve(nums, ar, word, ans + nums[row][col], row, col + 1);
            }
            if(temp)
                return true;
            if(col > 0){
                int[][] ar = path.clone();
                ar[row][col] = 1;
                temp = temp || solve(nums, ar, word, ans + nums[row][col], row, col - 1);
            }
            if(temp)    return temp;

            if(row > 0)
            {
                int[][] ar = path.clone();
                ar[row][col] = 1;
                temp = temp || solve(nums, ar, word, ans + nums[row][col], row - 1, col);
            }

        }

        return temp || word.equals(ans);
    }

    public static void main(String[] args) {

        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };


        System.out.println(exist(board, "AAB"));

    }

}
