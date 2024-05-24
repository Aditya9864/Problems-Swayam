//RECURSIVE
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
         return 0;
        int ans=cc(coins,amount,coins.length-1);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int cc(int coins[], int amount, int i)
    {
        if(i<0 || amount<0)
         return Integer.MAX_VALUE;
        if(amount==0)
         return 0;
         
        int t=cc(coins, amount-coins[i], i);
        if(t != Integer.MAX_VALUE)
         t++;

        int nt=cc(coins,amount,i-1);
        
        return Math.min(t,nt);
    }
}
*/

//BOTTOM-UP
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]= new int[n+1][amount+1];
        for(int j=0; j<=amount; j++)
            dp[0][j] = Integer.MAX_VALUE;
    
        for(int i = 0; i <= n; i++) 
            dp[i][0] = 0;
        
        for(int i=1; i <=n; i++) 
        {
            for(int j=1; j<= amount; j++) 
            {
                if(coins[i-1] <= j) 
                {
                    if(dp[i][j-coins[i-1]] != Integer.MAX_VALUE) 
                        dp[i][j]= Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                    else
                        dp[i][j]= dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount]==Integer.MAX_VALUE? -1:dp[n][amount];
    }
}