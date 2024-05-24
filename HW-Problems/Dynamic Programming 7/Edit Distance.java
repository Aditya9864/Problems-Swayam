/*
//RECURSION
class Solution {
    public int minDistance(String word1, String word2) {
        return minops(word1 ,word2, word1.length()-1 ,word2.length()-1);
    }
    int minops(String t1,String t2,int i,int j)
    {
        if(i<0 && j<0)
         return 0;
        if(i<0)
         return j+1;
        if(j<0)
         return i+1;

        if( t1.charAt(i) == t2.charAt(j) )
         return minops(t1,t2,i-1,j-1);
        else
        {
            int replace= minops(t1,t2,i-1,j-1);
            int add= minops(t1,t2,i,j-1);
            int remove= minops(t1,t2,i-1,j);

            return Math.min(replace , Math.min(add,remove))+1;
        }
    }
}



//MEMOIZATION
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int memo[][]= new int[m][n];
        for(int a[]: memo)
         Arrays.fill(a,-1);

        return minops(word1 ,word2, m-1 ,n-1, memo);
    }
    int minops(String t1,String t2,int i,int j, int memo[][])
    {
        if(i<0 && j<0)
         return 0;
        if(i<0)
         return j+1;
        if(j<0)
         return i+1;

        if(memo[i][j] != -1)
         return memo[i][j]; 

        if( t1.charAt(i) == t2.charAt(j) )
         return minops(t1, t2, i-1, j-1, memo);
        else
        {
            int replace= minops(t1 ,t2 ,i-1 ,j-1, memo);
            int add= minops(t1 ,t2 ,i ,j-1, memo);
            int remove= minops(t1 ,t2 ,i-1 ,j, memo);

            memo[i][j]= Math.min(replace , Math.min(add,remove))+1;
            return memo[i][j];
        }
    }
}



//DP
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=0;

        for(int j=0; j<n+1; j++)
         dp[0][j]=j;

        for(int i=0; i<m+1; i++)
         dp[i][0]=i;

        for(int i=1; i<m+1 ;i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if( word1.charAt(i-1) == word2.charAt(j-1) )
                  dp[i][j]= dp[i-1][j-1];
                else
                {
                    int replace= dp[i-1][j-1] +1;
                    int add= dp[i][j-1] +1;
                    int remove= dp[i-1][j] +1;

                    dp[i][j]= Math.min(replace, Math.min(add,remove));
                }
            }
        }
        return dp[m][n];
    }
}
*/


//DP SPACE OPTIMIZED
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[2][n+1];
        for(int j=0; j<n+1; j++)
         dp[0][j]=j;

        int curr=1;
        int prev=0;
        for(int i=1; i<m+1 ;i++)
        {
            dp[curr][0]=i;
            for(int j=1; j<n+1; j++)
            {
                if( word1.charAt(i-1) == word2.charAt(j-1) )
                  dp[curr][j]= dp[prev][j-1];
                else
                {
                    int replace=  dp[prev][j-1]+1;
                    int add= dp[curr][j-1] +1;
                    int remove= dp[prev][j] +1;

                    dp[curr][j]= Math.min(replace, Math.min(add,remove));
                }
            }
            prev=curr;
            curr=prev^1;
        }
        return dp[m%2][n];
    }
}