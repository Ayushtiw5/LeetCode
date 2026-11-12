class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int imax = 0, icount = 0;
        int dmax = 0, dcount = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                icount++;
                dcount = 0;
            } else if (nums[i] > nums[i + 1]) {
                dcount++;
                icount = 0;
            } else {
                icount = 0;
                dcount = 0;
            }

            imax = Math.max(imax, icount);
            dmax = Math.max(dmax, dcount);
        }

        return Math.max(imax + 1, dmax + 1);
    }
}