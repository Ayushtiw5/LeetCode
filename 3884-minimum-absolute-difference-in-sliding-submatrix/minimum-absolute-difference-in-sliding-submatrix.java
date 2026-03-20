class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Output array ka size (m-k+1) x (n-k+1) hoga
        int rows = m - k + 1;
        int cols = n - k + 1;
        int[][] ans = new int[rows][cols];
        
        // Har possible top-left corner (i, j) ke liye
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                // k×k submatrix ke saare elements collect karo
                int[] elements = new int[k * k];
                int idx = 0;
                
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        elements[idx++] = grid[r][c];
                    }
                }
                
                // Sort karo - adjacent elements ka diff minimum hoga
                Arrays.sort(elements);
                
                // Minimum absolute difference nikalo
                int minDiff = Integer.MAX_VALUE;
                for (int x = 1; x < elements.length; x++) {
                    int diff = elements[x] - elements[x - 1]; // sorted hai to always >= 0
                    if (diff == 0) { // Same values → skip (distinct chahiye)
                        continue;
                    }
                    minDiff = Math.min(minDiff, diff);
                }
                
                // Agar sab same values hain
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }
        
        return ans;
    }
}