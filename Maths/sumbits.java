class sumbits{
    public static void main(String[] args) {
        int n = 11;
        int ans = hammingWeight(n);
        System.out.println(ans);    
    }
    static int hammingWeight(int n) {
        int ct = 0;
        while (n > 0){
            ct += n & 1;
            n = n >> 1;
        }
        return ct;
    }
}