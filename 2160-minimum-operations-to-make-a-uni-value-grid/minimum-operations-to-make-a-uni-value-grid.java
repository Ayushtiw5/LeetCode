class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] freq = new int[10001];
        int rem = grid[0][0] % x;

        for (int[] row : grid) {
            for (int val : row) {
                if (val % x != rem) {
                    return -1;
                }

                freq[val]++;
            }
        }

        int count = 0;
        int target = (m * n) >> 1;
        int median = 0;

        for (int i = 0; i < freq.length; i++) {
            count += freq[i];

            if (count > target) {
                median = i;
                break;
            }
        }

        int operations = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                operations += (Math.abs(i - median) / x) * freq[i];
            }
        }

        return operations;
    }
}