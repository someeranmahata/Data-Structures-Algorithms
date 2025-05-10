package Dyanamic_Programming;
import java.util.*;
public class PascalsQues {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans = new ArrayList<>(numRows);
        if(numRows == 0)
            return ans;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        for(int i = 1; i < numRows; i++){
            List<Integer> temp = ans.get(i - 1);
            List<Integer> element = new ArrayList<>();
            element.add(1);
            for(int j = 1; j < i; j++){
                element.add(temp.get(j - 1) + temp.get(j));
            }
            element.add(1);
            ans.add(element);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = generate(3);
        for(List<Integer> k : ans)
            System.out.println(k);

    }
}
