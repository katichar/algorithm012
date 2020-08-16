
class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int [m+1][n+1];
        return dfs(m,n,dp);
    }
    public int dfs(int m, int n,int[][] dp){
        if(m<=0 || n<=0) return 0;
        else if(m == 1 || n == 1) return 1;
        if(dp[m][n]>0) return dp[m][n];

        dp[m-1][n] = dfs(m-1,n,dp);
        dp[m][n-1] = dfs(m,n-1,dp);
        dp[m][n]=dp[m-1][n] + dp[m][n-1];
        return dp[m][n];
    }
}