import java.util.*;

public class MakeTest{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = random(1, 1000);
        StringBuilder st = new StringBuilder();
        
        st.append(t + "\n");
        for(int i = 0; i < t; i++){
            int n = random(1, 1000);
            StringBuilder exp = new StringBuilder();
            
            char[] move = {'L', 'R'};
            for(int j = 0; j < n; j++){
                char c = move[random(0, 1)];
                exp.append(c);
            }
            st.append(n + "\n");
            st.append(exp + "\n");
        }
        System.out.println(st);
        

    }
    static int random(int min, int max){
        int num = (int) (Math.random() * (max - min + 1)) + min;   
        return num;
    }
}
