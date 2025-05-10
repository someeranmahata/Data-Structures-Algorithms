class matrix {
    public static int countNegatives(int[][] grid) {
        //counting number of negative integers in sorted array
        int count = 0;
        for (int row = 0; row<grid.length; row++){
            for (int col = 0; col<grid[row].length; col++){
                if (grid[row][col]<0){
                    count++;
                }
            }
        }
        return count;
        }
    public static void main(String[] args){
        int[][] arr = {{1,2,-3},{-4,-5,-8,2}};
        int res=countNegatives(arr);
        System.out.println("the answer is:"+res);
    }
    
    }
