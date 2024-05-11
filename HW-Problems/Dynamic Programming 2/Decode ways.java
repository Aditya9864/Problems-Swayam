
//RECURSION
class Solution {
    public int numDecodings(String s) {
        return ways(s,0);
    }
    int ways(String s, int i)
    {
        if(i==s.length())
         return 1;
        if(s.charAt(i)=='0')
         return 0;
        if(i==s.length()-1)
         return 1;

        int ans=ways(s,i+1);
        if( (s.charAt(i)-48)*10 + (s.charAt(i+1)-48) <=26)
         ans+=ways(s, i+2);

        return ans;
    }
}


//MEMOIZATION
class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int cache[]= new int[n+1];
        Arrays.fill(cache,-1);
        return ways(s,0,cache);
    }
    int ways(String s, int i, int cache[])
    {
        if(i==s.length())
         return 1;
        if(s.charAt(i)=='0')
         return 0;
        if(i==s.length()-1)
         return 1;
        if(cache[i] != -1)
         return cache[i];

        int ans=ways(s,i+1,cache);
        if( (s.charAt(i)-48)*10 + (s.charAt(i+1)-48) <=26)
         ans+=ways(s, i+2, cache);

        cache[i]=ans;
        return cache[i];
    }
}



//DP
class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]= s.charAt(0)!='0'?1:0;
        for(int i=2; i<n ; i++)
        {
            int ans=(s.charAt(i)-48)*10 + (s.charAt(i-1)-48);
            if(ans <=9 )
              dp[i] +=dp[i-1];
            if(ans>=10 && ans <=26 )
              dp[i] +=dp[i-2];
        }
        return dp[n];
    }
}