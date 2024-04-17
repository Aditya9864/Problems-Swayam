class Solution {
    class Trio
    {
        int r;
        int c;
        int time;
        Trio(int i,int j,int time)
        {
            this.r=i;
            this.c=j;
            this.time=time;
        }
    }
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    int notrotten=0;
    Queue<Trio> q=new LinkedList();

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                 q.add(new Trio(i,j,0));
                if(grid[i][j]==1)
                 notrotten++;
            }
        }
        return bfs(grid,n,m);
    }
    int bfs(int grid[][],int n,int m)
    {
        int min=0;
        while(!q.isEmpty())
        {
            Trio node=q.poll();
            min=node.time;
            for(int dir[]:directions)
            {
                int newr=node.r+dir[0];
                int newc=node.c+dir[1];
                if(newr<0 || newc<0 || newr>=n || newc>=m || grid[newr][newc]!=1)
                  continue;

                grid[newr][newc]=2;
                notrotten--;
                q.add(new Trio(newr,newc,node.time+1)); 
            }
        }
        if(notrotten>0)
         return -1;
        else
        return min;
    }
}