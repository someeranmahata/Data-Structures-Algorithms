//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of word");
        int num=sc.nextInt();
        sc.nextLine();
        String[] str =new String[num];
        for(int i=0;i<num;i++){
            str[i]=sc.nextLine();
        }
        String[][] str1=new String[num][num];
        for(int i=0;i<num;i++){
            String str2=str[i];
            String[] arr=str2.split(" ");
            for(int j=0;j<num;j++){
                str1[i][j]=arr[j];
            }
        }
        System.out.println("Element in Str is");
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                System.out.print(str1[i][j]+" ");
            }
            System.out.println();
        }
        String[][] str3=new String[num][num];
        //String[][] str4=new String[num][num];
        for(int i=0;i<num;i++){
            for(int j=0,a=num-1;j<num;j++,a--){
                str3[i][j]=str1[i][a];
            }
        }
        System.out.println("The element are: ");
        for(int i=num-1;i>=0;i--){
            for(int j=0;j<num;j++){
                System.out.print(str3[i][j]+" ");
            }
            System.out.println("");
        }

    }
}