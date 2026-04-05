import java.util.*;
class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        
        

    }
    int maxWalls(int[] robots, int[] distance, int[] walls) {

        /*
         robots and the walls can be placed in the same palce
         bullet can't pass across a robot but can cross across the walls upto it's range
         maximum number of unique walls taht can be destroyed by the robots
         */

       
        int lim = 0;
        for(int i : walls)
            lim = Math.max(lim, i);

        int[] mark = new int[lim + 1];  //mark whether the wall is destroyed or not
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : walls)
            mark[i]++;

         for(int i = 0; i < robots.length; i++)
             map.put(robots[i], distance[i]);






    }

}
