import java.util.ArrayList;
import java.util.Arrays;

public class serachword {
    public static void main(String[] args) {
        System.out.println((int) 'A');
        char[][] data = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };

    }
    static String exist(char[][] board, String word) {
        //Finding the location of cell of 1st letter of the word
        String[] add = new String[5];
        for (int i = 0; i < board.length ; i++){
            int ind = 0;
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0))
                    add[ind] = (("" + i) + j);
            }
        }
        return Arrays.toString(add);
    }

}
