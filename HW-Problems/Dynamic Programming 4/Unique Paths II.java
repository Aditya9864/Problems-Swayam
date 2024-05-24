class Solution {
    public int uniquePathsWithObstacles(int[][] oG) {
        int m=oG.length;
        int n=oG[0].length;
        if(oG[m-1][n-1]==1 || oG[0][0]==1)
         return 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
             {
                 if(oG[i][j]==1)
                  oG[i][j]=-1;
             }
        }
        boolean isblocked=false;
        for(int i=0;i<m;i++)
        {
            if(oG[i][0]==-1)
             isblocked=true;
            if(!isblocked)
                oG[i][0]=1;
            else
             oG[i][0]=0;
        }
        isblocked=false;
        for(int i=0;i<n;i++)
        {
            if(oG[0][i]==-1)
             isblocked=true;
            if(!isblocked)
                oG[0][i]=1;
            else
             oG[0][i]=0;
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(oG[i][j]==-1)
                 continue;
                if(oG[i-1][j]==-1 && oG[i][j-1]==-1)
                 oG[i][j]=0;
                else if(oG[i][j-1]==-1)
                 oG[i][j]=oG[i-1][j];
                else if(oG[i-1][j]==-1)
                 oG[i][j]=oG[i][j-1];
                else
                 oG[i][j]=oG[i-1][j]+oG[i][j-1];
            }
        }
        return oG[m-1][n-1];
    }
}