class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use division instead of multiplication to avoid overflow
            if (mid <= x / mid) {
                ans = mid;      // mid is a candidate
                left = mid + 1; // try bigger
            } else {
                right = mid - 1; // try smaller
            }
        }
        return ans;
    }
}
