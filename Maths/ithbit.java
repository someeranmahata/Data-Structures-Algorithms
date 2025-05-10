class ithbit{
    public static void main(String[] args) {
        //Finding ith bit of a number
        int num = 245;
        System.out.println("Binary code "+Integer.toBinaryString(num));
        int pos = 3;
        System.out.println(ithterm(num, pos));

    }
    static int ithterm(int num, int pos){
        num = num >> pos-1;
        System.out.println("Binary code "+Integer.toBinaryString(num));
        return (1 & num);
    }
}
