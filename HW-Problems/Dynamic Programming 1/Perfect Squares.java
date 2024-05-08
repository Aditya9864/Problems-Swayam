//RECURSION
class Solution {
    public int numSquares(int n) {
         if(n==0) 
           return 0;

        int res= Integer.MAX_VALUE;
        for(int i=1; i*i<=n ; i++)
            res= Math.min(res, 1+ numSquares(n-(i*i)) );

        return res;
    }
}


//MEMOIZATION
class Solution {
    public int numSquares(int n) {
        int cache[]=new int[n+1];
        Arrays.fill(cache,-1);
        return find(n,cache);
    }
    int find(int n, int cache[])
    {
        if(n<=0) 
           return 0;
        if(cache[n] != -1)
           return cache[n];

        int res= Integer.MAX_VALUE;
        for(int i=1; i*i<=n ; i++)
            res= Math.min(res,1 + find( n-(i*i), cache) );

        cache[n]=res;
        return cache[n];
    }
}


//DP/BOTTOM-UP
class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j*j <= i; j++) 
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
        }
        return dp[n];
    }
}
