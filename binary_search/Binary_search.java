import java.util.Scanner;
class Binary_search{
    public static void main(String[] args) {
        //Binary Search
        Scanner inp = new Scanner(System.in);
        int[] arr = new int[10];
        int l;
        System.out.println("Enter the lenth of Array:");
        l = inp.nextInt();
        
        System.out.println("Enter the number:");
        for (int i = 0; i<l ; i++){        
            arr[i] = inp.nextInt();
        }
        
        System.out.println("Enter the element whoose index you want to search:");
        int num = inp.nextInt();
        int result = -1;

        int last = l-1;
        int mid = last/2;
        int start = 0;

        while(arr[mid] < arr[last]) {        //Searching

            if (num < arr[mid]){
                last = mid - 1;
            }
            else if (num > arr[mid]){
                start = mid + 1;
            }
            else{
                break;
                }
            mid = (last + start) / 2;    
        }
        System.out.println("The index of the number is:" + mid);
        

    }
}
