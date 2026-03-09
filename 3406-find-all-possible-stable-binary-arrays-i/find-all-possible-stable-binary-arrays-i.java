class Solution {

    int MOD = 1000000007;
    Integer dp[][][][];

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero+1][one+1][2][limit+1];

        int a = solve(zero-1, one, 0, 1, limit);
        int b = solve(zero, one-1, 1, 1, limit);

        return (a + b) % MOD;
    }

    int solve(int z, int o, int last, int cnt, int limit){

        if(z < 0 || o < 0) return 0;

        if(z == 0 && o == 0) return 1;

        if(dp[z][o][last][cnt] != null)
            return dp[z][o][last][cnt];

        long ans = 0;

        if(last == 0){

            if(z > 0 && cnt < limit)
                ans += solve(z-1, o, 0, cnt+1, limit);

            if(o > 0)
                ans += solve(z, o-1, 1, 1, limit);
        }
        else{

            if(o > 0 && cnt < limit)
                ans += solve(z, o-1, 1, cnt+1, limit);

            if(z > 0)
                ans += solve(z-1, o, 0, 1, limit);
        }

        return dp[z][o][last][cnt] = (int)(ans % MOD);
    }
}