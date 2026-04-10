import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();

        int test = sc.nextInt();
        while(test-- > 0){

            long n = sc.nextLong();
            long m = sc.nextLong();
            
            long a = sc.nextLong();
            long b = sc.nextLong();

            boolean flag = true;
            List<String> ind = new ArrayList<>();
            long i = 1; long j = 1;
            //start from going down
            boolean step = true;
           
            while(flag){
                String pos = "" + i + "" + j;
                if(ind.contains(pos))
                    flag = false;
                else{
                    ind.add(pos);
                    if(step){
                    //move down
                        i = ((i + a - 1) % n) + 1; 
                    }
                    else
                        j = ((j + b - 1) % m) + 1;

                }
                step = !step;

            }
//            System.out.println(ind);
            if(ind.size()/m == n && ind.size()%m == 0 ){
                st.append("YES\n");
                continue;
                    
            }
            flag = true;
            step = false;
            
            ind = new ArrayList<>();
            i = 1; j = 1;
            
            while(flag){
                String pos = "" + i + "" + j;
                if(ind.contains(pos))
                    flag = false;
                else{
                    ind.add(pos);
                    if(step){
                    //move down
                        i = ((i + a - 1) % n) + 1; 
                    }
                    else
                        j = ((j + b - 1) % m) + 1;

                }
                step = !step;

            }

//            System.out.println(ind);
            if(ind.size()/m == n && ind.size()%m == 0 )
                st.append("YES\n"); 
            else
                st.append("NO\n");
        }

        System.out.println(st);
    }
}
