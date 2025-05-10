
import java.util.ArrayList;

class factors{
    public static void main(String[] args){
        int n = 40;
        factor1(n);
        System.out.println("\n");
        factor2(n);
        System.out.println("\n");
        factor3(n);
    }
    
    static void factor1(int n){
        for (int i = 1; i <= n; i++){
            if (n % i == 0)
                System.out.print(i+ " ");
        }
    }
    
    static void factor2(int n){
        //Reducing the runtime complexity
        for (int j = 1; j <= Math.sqrt(n); j++){
            if (n % j == 0){
                if (n%j == j){
                    System.out.print(j+" ");
                }
                else
                    System.out.print(j + " " + n/j+ " ");
            }
        }
    }
    
    static void factor3(int n){
        
        //Reducing the runtime complexity and giving ans in ascending order

        ArrayList<Integer> val = new ArrayList<Integer>();
        for (int j = 1; j <= Math.sqrt(n); j++){
            if (n % j == 0){
                if (n%j == j){
                    System.out.print(j+" ");
                }
                else
                    System.out.print(j + " ");
                    val.add(n/j);
            }
        }
        
        for (int i = val.size()-1; i>=0; i--){
            System.out.print(val.get(i) + " ");
        }
    }
    
}