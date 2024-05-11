//DP
class Solution
{
    long M = 1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
        long dp[]=new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++)
        {
            long single= dp[i-1]%M;
            long paired= (i-1)*dp[i-2]%M;
            dp[i] =(single+paired)%M;
        }
        
        return dp[n];
    }
}    
 

//MEMOIZATION
class Solution
{
    int M= 1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
        int cache[]= new int[n+1];
        Arrays.fill(cache,-1);
        cache[0]=0;
        cache[1]=1;

        return find(n,cache);
    }
    int find(int n, int cache[]) 
    {
        if(n<2)
            return 1;
        if(cache[n] != -1)
            return cache[n];
            
        int single= find(n-1,cache);
        int paired=(n-1)*find(n-2,cache);
        long ans=single +paired;
        cache[n]= (int)(ans%M);
        return cache[n];
    }
}    
 

//RECURSION
class Solution
{
    int M= 1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
        return find(n);
    }
    int find(int n) 
    {
        if(n<2)
            return 1;
            
        int single= find(n-1);
        int paired=(n-1)*find(n-2);
        long ans=single +paired;
        return (int)(ans%M);
    }
}    
 