import java.util.*;
class Solution {
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i=0; i<mat.length; i++){
            //pd
            sum+= mat[i][i];
            //sd
            if(i != mat.length-1-i){
                sum+= mat[i][mat.length-1-i];
            }
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int mat[][] = new int[x][y];

        int n = mat.length;
        int m = mat[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.print(diagonalSum(mat));
    }
}