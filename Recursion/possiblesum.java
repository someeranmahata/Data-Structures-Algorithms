import java.util.ArrayList;

public class possiblesum {
    public static void main(String[] args){
       // PossibleWays("", 4);
        System.out.println( PossibleWays2("", 4));
    }
    static void PossibleWays(String ans,int target){
        if (target == 0)
        {
            System.out.println(ans);
            return ;
        }
        for (int i = 1; i <= 6 && i <= target; i++){
            PossibleWays(ans + i, target-i);
        }
    }
    // Returning the answer in ans ArrayList
    static ArrayList<String> PossibleWays2(String ans,int target){
        if (target == 0)
        {   ArrayList<String> result = new ArrayList<>();
            result.add(ans);
            return result;
        }
        ArrayList<String> end_result = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++){
            end_result.addAll(PossibleWays2(ans + i, target-i));
        }
        return end_result;
    }
}
