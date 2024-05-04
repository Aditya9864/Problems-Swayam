//RECURSION
class Solution {
    public int climbStairs(int n) {
        if(n==0)
         return 0;
        if(n==1)
         return 1;
        if(n==2)
         return 2;

        return climbStairs(n-1)+climbStairs(n-2);
    }
}


//MEMOIZATION
class Solution {
    int cache[]=new int[46];
    public int climbStairs(int n) {
        if(cache[n]!=0)
         return cache[n];

        if(n==0)
         cache[0]=0;
        else if(n==1)
         cache[1]=1;
        else if(n==2)
         cache[2]=2;
        else
        cache[n]=climbStairs(n-1)+climbStairs(n-2);

        return cache[n];
    }
}


//BOTTOM-UP
class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        if(n==0)
         return 0;
        if(n==1)
         return 1;
        if(n==2)
         return 2;
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}

//BOTTOM-UP OPTIMIZED
class Solution {
    public int climbStairs(int n) {
        if(n==0)
         return 0;
        if(n==1)
         return 1;
        if(n==2)
         return 2;
        int a=1;
        int b=2;
        int c=0;
        for(int i=3;i<=n;i++)
        {
            c=a+b;
            a=b;
            b=c;
        }

        return c;
    }
}
