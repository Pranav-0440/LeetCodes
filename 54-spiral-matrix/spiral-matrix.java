import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }

            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            // Bottom
            if (startRow < endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
            }

            // Left
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return result;
    }

    // Optional test main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // rows
        int m = sc.nextInt(); // cols

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();

        Solution sol = new Solution();
        List<Integer> result = sol.spiralOrder(matrix);

        for (int num : result)
            System.out.print(num + " ");
    }
}