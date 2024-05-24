/*  RECURSION+MEMO
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int cache[][]=new int[text1.length()][text2.length()];
        for (int a[]:cache)
            Arrays.fill(a,-1);

        return lcs(text1, text2, 0, 0, cache);
    }
    int lcs(String s1, String s2, int i, int j, int cache[][]) 
    {
        if (i==s1.length() || j==s2.length()) 
          return 0;

        if(cache[i][j] != -1) 
          return cache[i][j];

        if(s1.charAt(i) == s2.charAt(j)) 
          cache[i][j]=lcs(s1, s2, i+1, j+1, cache)+1;
        else
          cache[i][j]=Math.max(lcs(s1, s2, i+1, j, cache), lcs(s1, s2, i, j+1, cache));
          
        return cache[i][j];
    }
}
*/


//DP
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1; i<=l1; i++) 
        {
            for(int j=1; j<=l2; j++) 
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j]= dp[i-1][j-1]+1;
                else 
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[l1][l2];
    }
}