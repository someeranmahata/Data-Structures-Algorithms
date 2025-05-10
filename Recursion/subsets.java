import java.util.ArrayList;
import java.util.Scanner;
public class subsets {
    public static void main(String[] args){
        System.out.println(subset2("", "abc"));
    }
    static void subset(String p, String org){
        if (org.isEmpty()){
            System.out.println(p);
            return;
        }
        char a = org.charAt(0);
        subset(p + a, org.substring(1));
        subset(p, org.substring(1));
    }

    static ArrayList<String> subset2(String p, String org){
        if (org.isEmpty()){
            ArrayList<String> List = new ArrayList<>();
            List.add(p);
            return List;
        }
        char a = org.charAt(0);

        ArrayList<String> left = subset2(p + a, org.substring(1));
        ArrayList<String> right = subset2(p, org.substring(1));

        left.addAll(right);
        return left;
    }
}
