/*  DP+MEMO 
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1)
         return 1;

        int cache[][]=new int[m+1][n+1];
        for(int a[]:cache)
         Arrays.fill(a,-1);

        return paths(m-1,n-1,cache);
    }
    int paths(int m,int n,int cache[][])
    {
        if(cache[m][n] != -1)
         return cache[m][n];
        if(m==0 && n==0)
         cache[m][n]=0;
        else if (m==0 || n==0)
         cache[m][n]=1;
        else
          cache[m][n]=paths(m-1,n,cache)+paths(m,n-1,cache);
        return cache[m][n];
    }
}
*/

//RECURSION
class Solution {
    public int uniquePaths(int m, int n) {
        int a[][]=new int[m][n];
        a[0][0]=-1;
        for(int i=0;i<n;i++)
         a[0][i]=1;
        for(int i=0;i<m;i++)
         a[i][0]=1;

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
                a[i][j]=a[i-1][j]+a[i][j-1];
        }
        return a[m-1][n-1];
    }
}