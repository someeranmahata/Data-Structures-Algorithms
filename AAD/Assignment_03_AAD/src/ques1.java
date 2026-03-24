import java.awt.image.ImageProducer;
import java.util.*;
class HT{
    int m;
    int[] ar;
    int collision;

    HT(){
        m = 10;
        ar = new int[m];
        collision = 0;
        Arrays.fill(ar, -1);
    }
    void add(int x){
        int mod = modval(x, m);
        if(ar[mod] != -1)
            collision++;
        else
            ar[mod] = x;
    }
    int modval(int x, int m){
        return x%m;
    }
    List<LinkedList<Integer>> list;
    void separateChaining(int[] ar){
        list = new ArrayList<LinkedList<Integer>>();

        for(int i = 0; i < m; i++){
            list.add(new LinkedList<Integer>());
        }

        for(int ele : ar){
            addChain(ele);
        }
        System.out.println("Succesfully done");
    }
    void addChain(int ele){
        int mod = ele%m;
        list.get(mod).add(ele);
    }

    void quadraticProbAdd(int ele){
        int mod = modval(ele, m);
        int ind = mod;
        int i = 1;
        while(ar[ind] != -1){
            ind = (ind + i*i)%10;
            i++;
        }
        ar[ind] = ele;
        System.out.println("Added " + ele + " at index : " + ind);
    }

    void linearProbAdd(int ele){
        int mod = modval(ele, m);
        while(ar[mod] != -1){
            mod++;
            mod %= 10;
        }
        System.out.println("Added " + ele + " at index : " + mod);
        ar[mod] = ele;
    }

}
class ques1 {
    boolean checkAnagram(String first, String sec){
        Map<Character, Integer> firstcount = new HashMap<>();
        Map<Character, Integer> seccount = new HashMap<>();

        int n = first.length();
        int m = sec.length();

        for(int i = 0; i < n; i++){
            char c = first.charAt(i);
            firstcount.put(c, firstcount.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < m; i++){
            char c = sec.charAt(i);
            seccount.put(c, seccount.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> ele : firstcount.entrySet()){
            if(ele.getValue() != seccount.getOrDefault(ele.getKey(), 0))
                return false;
        }

        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];
        HT hashtable = new HT();

        for(int i = 0; i < n; i++){
            ar[i] = sc.nextInt();
            hashtable.quadraticProbAdd(ar[i]);
        }
        System.out.println("Number of collision : " + hashtable.collision);
        hashtable.separateChaining(ar);
        System.out.println(hashtable.list);
//        System.out.println(checkAnagram("aaadddnnn", "dddaaannn"));
//        System.out.println(checkAnagram("aaadddnnnn", "dddaaannx"));
    }
}
