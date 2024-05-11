class Solution{
    static int maxSum(int N, int mat[][])
    {
        // code here
        int dp[]=new int[N+1];
        dp[1] = Math.max(mat[0][0], mat[1][0]);
        dp[2] = Math.max(dp[1], Math.max(mat[0][1], mat[1][1]));
        
        for(int i=3;i<=N;i++)
        {
           int take = Math.max(mat[0][i-1], mat[1][i-1])+ dp[i-2];
           dp[i] = Math.max( take , dp[i-1]);
        }
        return dp[N];
    }
}