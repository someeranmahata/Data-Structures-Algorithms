class rlshift{
    public static void main(String[] args){
        int num = 234567;
        System.out.println(Integer.toBinaryString(num));
        System.out.println("-------------------------");

        while (num >0){
            System.out.println(num & 1);
            num = num >> 1;
            System.out.println(Integer.toBinaryString(num));
            System.out.println("-------");
        }
    }

}