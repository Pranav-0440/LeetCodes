class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, max = n * n;

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (num <= max) {
            // left → right
            for (int i = left; i <= right && num <= max; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // top → bottom
            for (int i = top; i <= bottom && num <= max; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // right → left
            for (int i = right; i >= left && num <= max; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // bottom → top
            for (int i = bottom; i >= top && num <= max; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}
