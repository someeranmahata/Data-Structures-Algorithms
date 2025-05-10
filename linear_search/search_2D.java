import java.util.Scanner;
//Returning an array sum of the element of 2-d array
class search_2D{
    public static void main(String[] args)
    {
        int[][] check = {{1,2,3},{4,5,6},{7,8,9}};
        int [] newarr = Ans(check);
        /*System.out.println("The array containing the sum of elements:"+ newarr);
        } */
       int[] a = {1,2,3,4};
       System.out.println("result is:"+elementsum(a));
       System.out.println("returning array"+newarr);
       int[] newarr2 = newarr;
       for (int i=0; i<newarr2.length; i++){
        System.out.println(newarr[i]);
       }
    }
    
    //method to return array containing the sum of the elements present in the array
    static int[] Ans( int[][] arr)
    {
        int[] ans = new int[arr.length];
        for (int i = 0; i<arr.length ;i++){
                ans[i]=elementsum(arr[i]);
        }
        return ans;
    }
    //method to do sum
    static int elementsum(int[] element){
        int count = 0;
        for (int i = 0; i<element.length; i++)
        {
            count+=element[i];
        }
        return count;
    }
    }
