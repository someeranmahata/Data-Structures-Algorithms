import java.util.ArrayList;

public class mazepatterm {
    public static void main(String[] args){
        System.out.println(maze2("",3,3));
        maze2("",3,3);
    }

    static void maze(String ans,int c, int r){
        if (c == 1 && r == 1){
            System.out.println(ans);
            return ;
        }
        if (c > 1)
            maze(ans + "D",c-1,r);
        if (r > 1)
            maze(ans + "R",c,r-1);

    }
    //Returning the answer in Array list
    static ArrayList<String> maze2(String ans,int c, int r){
        if (c == 1 && r == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();

        if (c > 1)
            result.addAll(maze2(ans + "D",c-1,r));
        if (r > 1)
            result.addAll(maze2(ans + "R",c,r-1));
        return result;
    }

}
