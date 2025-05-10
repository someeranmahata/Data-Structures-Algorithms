
import java.util.ArrayList;
import java.util.Arrays;

public class backtracking {
    public static void main(String[] args) {
        int[][] data = {
                {1,1,1},
                {1,1,1},
                {1,1,1},
        };

        System.out.println(maze("",data,0,0));

        int[][] path = new int[data.length][data[0].length];
        maze2("",data,0,0,path,1);
    }
    static ArrayList<String> maze(String ans, int[][] ar, int c, int r){
        if (c == 2 && r == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list ;
        }
        ArrayList<String> nlist = new ArrayList<>();

        if (ar[c][r] == 0)
            return nlist;

        if (r > 0 && ar[c][r] == 1) {
            ar[c][r] = 0;
            nlist.addAll(maze(ans + "U", ar, c, r - 1));
        }if (c < 2) {
            ar[c][r] = 0;
            nlist.addAll(maze(ans + "R", ar, c + 1, r));
        }if (r < 2) {
            ar[c][r] = 0;
            nlist.addAll(maze(ans + "D", ar, c, r + 1));
        }
        ar[c][r] = 1;

        return nlist;
    }

    //Adding number to the path
    static void maze2(String ans, int[][] ar, int c, int r,int[][] path,int step){
        if (c == ar.length - 1 && r == ar[0].length - 1){
            path[c][r] = step ;
            for (int[] a: path){
                System.out.println(Arrays.toString(a));
            }
            System.out.println(ans);
            return ;
        }

        if (ar[c][r] == 0)
            return;
        ar[c][r] = 0;
        path[c][r] = step;

        if (r > 0 && ar[c][r] == 1) {
            maze2(ans + "U", ar, c, r - 1,path,step+1);
        }if (c < 2) {
            maze2(ans + "R", ar, c + 1, r,path,step+1);
        }if (r < 2) {
            maze2(ans + "D", ar, c, r + 1,path,step+1);
        }

        ar[c][r] = 1;
        path[c][r] = 0;

    }
}
