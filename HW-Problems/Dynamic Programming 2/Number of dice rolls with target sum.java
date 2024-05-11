/*
//RECURSION
class Solution {
    int mod=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        return (int)rec(n,k,target,cache);
    }
    long rec(int n,int face,int target, long cache[][])
    {
        if(target<0)
         return 0;
        if(n!=0 && target==0)
         return 0;
        if(n==0 && target!=0)
         return 0;
        if(n==0 && target==0) 
         return 1;
     
        long ans=0;
        for(int i=1;i<=face;i++)
            ans+= (rec(n-1,face,target-i,cache));

        return ans%mod;
    }
}



//MEMOIZATION
class Solution {
    int mod=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        long cache[][]=new long[n+1][target+1];
        for(long a[]:cache)
         Arrays.fill(a,-1);
        
        return (int)rec(n,k,target,cache);
    }
    long rec(int n,int face,int target, long cache[][])
    {
        if(target<0)
         return 0;
        if(n!=0 && target==0)
         return 0;
        if(n==0 && target!=0)
         return 0;
        if(n==0 && target==0) 
         return 1;
        if(cache[n][target] != -1)
         return cache[n][target];
     
        long ans=0;
        for(int i=1;i<=face;i++)
            ans+= (rec(n-1,face,target-i,cache));

        cache[n][target]= ans%mod;
        return cache[n][target];
    }
}
*/

//DP
class Solution {
    int mod=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int a[]:dp)
            Arrays.fill(a,0);
        
        dp[0][0]=1;
        for(int d=1;d<=n;d++)
        {
            for(int i=0; i<=target ;i++)
            {
                int w=0;
                for(int dv=1; dv<=k; dv++)
                {
                    if(i-dv<0)
                    continue;

                    dp[d][i]= (dp[d][i]+dp[d-1][i-dv])%mod;
                }
            }
        }
        return dp[n][target];
    }
}