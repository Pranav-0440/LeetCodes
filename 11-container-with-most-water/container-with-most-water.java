public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;                  // Start from the left end
        int right = height.length - 1; // Start from the right end

        while (left < right) {
            // Calculate area between lines at left and right
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;

            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++; // Move left pointer to try a taller line
            } else {
                right--; // Move right pointer to try a taller line
            }
        }

        return maxArea;
    }
}