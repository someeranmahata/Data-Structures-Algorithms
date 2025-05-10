import java.util.*;

public class chessboard {
    public static void main(String[] args){
        //chess board 4X4
        Scanner sc = new Scanner(System.in);
        int[] row = {5, 4, 3, 6};
        int[] col = {8, 2, 6, 7};
        int str = 1;
        int stc = 0;
        int tarr = 2;
        int tarc = 3;
        ArrayList<String> ans = maze2("", stc,str,tarc,tarr,row,col);
        System.out.println(ans);
        System.out.println("Minimum cost is :" + Add_min(ans));

    }
    static ArrayList<String> maze2(String ans,int c, int r,int endc, int endr,int[] row,int[] col){
        if (c == endc && r == endr){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();

        if (c < endc) {
            c+=1;
            result.addAll(maze2(ans + col[c], c , r, endc, endr, row, col));

        }
        if (r < endr) {
            r+=1;
            result.addAll(maze2(ans + row[r], c, r , endc, endr, row, col));
        }
            return result;
    }

    static int Add_min(ArrayList<String> ans){
        int minvalue = Integer.MAX_VALUE;
        for(String s: ans){
            int add = sum(s);
            if(add < minvalue)
                minvalue = add;
        }
        return minvalue;

    }
    static int sum(String s){
        int num = Integer.parseInt(s);
        int sum = 0;
        while(num > 0){
            sum+=num%10;
            num/=10;
        }System.out.println(sum);
        return sum;
    }
}
