/*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.*/
class matrice_2D{
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++){
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]){
                int start = 0;
                int last = matrix[i].length-1;
                int mid = (start+last)/2;
                while(matrix[i][start] <= matrix[i][last]){
                    if (target > matrix[i][mid]){
                        
                    }
                }
            }
            else 
            return false;
        }
        return false;
    }
}