package Work_Hashmaps;
import java.util.*;
public class workhash {
    public static void main(String[] args) {

        int[] ar = {2,2,3,3,3};
        System.out.println(findLucky(ar));

    }
    //Not working for ere
    //Question - to count possible ways of word typed by the repeatedly pressed character in a word, i.e 'abbcccc' = 5 => 'abbcccc' , 'abcccc', 'abbccc', 'abbcc' , 'abbc'
    public static int possibleStringCount(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            char temp = word.charAt(i);
            if(hm.containsKey(temp)){
                int freq = hm.get(temp);
                hm.put(temp, freq + 1);
            }
            else{
                hm.put(temp, 1);
            }
        }
        int count = 0;
        for(Map.Entry<Character, Integer> ele : hm.entrySet()){
            count += ele.getValue() - 1;
        }
        return count + 1;
    }
    //daily-1394
    public static int findLucky(int[] arr) {
        Arrays.sort(arr);
        int[] count = new int[arr[arr.length - 1] + 1];

        for(int i : arr){
            count[i]++;
        }
        System.out.println(Arrays.toString(count));
        for(int j = count.length - 1; j >= 0; j--){
            if(count[j] == j)
                return count[j];
        }
        return -1;
    }
}
