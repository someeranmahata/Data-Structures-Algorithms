import java.util.*;
public class Group {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, List<String>> hm = new HashMap<>();
        int[] ar = new int[strs.length];

        for(int i = 0; i < strs.length; i++){
            if(ar[i] == -1) continue;

            String temp = strs[i];
            List<String> list = new ArrayList<>();

            if(hm.containsKey(i))   list = hm.get(i);
            if(!hm.containsKey(i)) list = new ArrayList<>();

            for(int j = i; j < strs.length; j++){
                if(ar[j] == -1) continue;
                if(check(strs[j], temp)){
                    ar[j] = -1;
                    list.add(strs[j]);
                    hm.put(i, list);
                }
            }
            ans.add(list);

        }
        return ans;
    }
    public static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }

    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }

}
