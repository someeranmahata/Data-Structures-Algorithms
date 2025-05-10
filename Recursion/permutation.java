
//Permutation of String of length n is equals to n!

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args){
        System.out.println(permutationOfStringList("", "abc"));
    }
    static void permutationOfString(String ans, String org){
        if (org.isEmpty()){
            System.out.println(ans);
            return;
        }
        char a = org.charAt(0);
        for (int i = 0; i <= ans.length(); i++){    // Number of calls  = size of ans -1
            String f = ans.substring(0,i);
            String s = ans.substring(i,(ans.length()));
            permutationOfString(f + a + s, org.substring(1));
        }
    }
    static ArrayList<String> permutationOfStringList(String ans, String org){       //Returning in Array
        if (org.isEmpty()){
            ArrayList<String> al = new ArrayList<>() ;
            al.add(ans);
            return al;
        }
        char a = org.charAt(0);

        ArrayList<String> finar= new ArrayList<>();

        for (int i = 0; i <= ans.length(); i++){    // Number of calls  = size of ans -1
            String f = ans.substring(0,i);
            String s = ans.substring(i,ans.length());
            finar.addAll(permutationOfStringList(f + a + s, org.substring(1)));
        }
        return finar;
    }

}
