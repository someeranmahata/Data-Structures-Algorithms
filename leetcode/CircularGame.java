class CircularGame {
    public static int findTheWinner(int n, int k) {
        int[] mark = new int[n];
        return solve(0, mark, k, 0, n);
    }
    public static int solve(int st, int[] mark, int k, int curk, int count){
        if(count == 1){
            for(int i = 0; i < mark.length; i++){
                if(mark[i] != -1)  return i + 1;
            }
        }
        while(true){
            int i = st % mark.length;
            while(mark[i] != 0){
                i++;
                if(i == mark.length)
                    i = i % mark.length;
            }
            if(curk + 1 == k){
                mark[i] = -1;
                return solve((i + 1)%mark.length, mark, k, 0, count - 1);
            }
            return solve((i + 1)%mark.length, mark, k, curk + 1, count);
        }
    }



    public static void main(String[] args) {
        System.out.println(findTheWinner(6,5));
    }
}
