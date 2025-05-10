package leetcode;

public class contest422 {
    //Ques_01
    public static int maxContainers(int n, int w, int maxWeight) {
        return find(n*n, 0, w, maxWeight);
    }
    public static int find(int n, int ans, int w,int maxWeight){
        if(n == 0)
            if(maxWeight == 0)
                return ans;
            else
                return ans - 1;
        if(maxWeight <= 0){
            if(maxWeight == 0)
                return ans;
            else
                return ans - 1;
        }
        ans++;
        return find(n - 1, ans, w, maxWeight - w);
    }
    public static void main(String[] args){
        System.out.println(maxContainers(3, 2, 17));
    }
}
