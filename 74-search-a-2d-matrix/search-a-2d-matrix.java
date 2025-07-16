import java.util.*;
class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0 , col = matrix[0].length-1;
        while(row < matrix.length && col >= 0 ){
            if(matrix[row][col] == target){
                return true;
            }
            else if(target < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int matrix[][] = new int[x][y];
        int n = matrix.length, m = matrix[0].length;
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        searchMatrix(matrix, target);
    }
}