import java.util.*;
public class Hamburgers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int nb = sc.nextInt();
        int ns = sc.nextInt();
        int nc = sc.nextInt();


        int pb = sc.nextInt();
        int ps = sc.nextInt();
        int pc = sc.nextInt();

        long r = sc.nextLong();

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        long count = 0;
        while(r >= 0){
            int price = 0;
            
            if(nb == 0 && nc == 0 && ns == 0){
                count +=r/(pb + ps + pc);
                break;
            }
            else{
                for(int i = 0; i < 3; i++){
                if(i == 0){
                    if(nb < hm.getOrDefault('B', 0)){
                        price += (hm.getOrDefault('B', 0) - nb)*pb;
                        nb = 0;
                    }
                    else{
                        nb -= hm.getOrDefault('B', 0);
                    }
                }
                else if(i == 1){
                    if(ns < hm.getOrDefault('S', 0)){
                        price += (hm.getOrDefault('S', 0) - ns)*ps;
                        ns = 0;
                    }
                    else{
                        ns -= hm.getOrDefault('S', 0);
                    }
                }
                else{
                    if(nc < hm.getOrDefault('C', 0)){
                        price += (hm.getOrDefault('C', 0) - nc)*pc;
                        nc = 0;
                    }
                    else{
                        nc -= hm.getOrDefault('C', 0);
                    }
                }

            }
            }
            if(price > r)
                break;
            else
                count++;

            r -= price;
        }
        System.out.println(count);
    }
}
