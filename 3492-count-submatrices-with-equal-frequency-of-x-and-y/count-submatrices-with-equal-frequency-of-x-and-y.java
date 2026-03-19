class Solution {
    public int numberOfSubmatrices(char[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

      int[][] px = new int[n+1][m+1];
      int[][] py = new int[n+1][m+1];

      int count=0;

      for(int i =1;i<=n;i++){
        for(int j=1;j<=m;j++){
            px[i][j] = px[i-1][j]+px[i][j-1]-px[i-1][j-1];
            py[i][j] = py[i-1][j]+py[i][j-1]-py[i-1][j-1];

            if(grid[i-1][j-1] == 'X') px[i][j]++;
            if(grid[i-1][j-1] == 'Y') py[i][j]++;

            int x = px[i][j];
            int y =py[i][j];

            if(x==y && x>0) count++;
        }
      }
    return count;
    }
}