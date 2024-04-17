class Solution
{
    class Pair
    {
        int r;
        int c;
        Pair(int r,int c)
        {
            this.r=r;
            this.c=c;
        }
        
    }
    int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m =grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] res=new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                res[i][j] = Integer.MAX_VALUE;
                if (grid[i][j] == 1) 
                {
                    res[i][j]=0;
                    visited[i][j]=true;
                    queue.offer(new Pair(i,j));
                }
            }
        }
        while (!queue.isEmpty()) 
        {
            Pair p = queue.poll();
            int r=p.r;
            int c=p.c;
            
            for (int[] dir : directions) 
            {
                int newr= r+dir[0];
                int newc= c+dir[1];
                if (newr >=0 && newr< n && newc>=0 && newc< m && !visited[newr][newc]) 
                {
                    res[newr][newc] = res[r][c]+1;
                    visited[newr][newc]=true;
                    queue.offer(new Pair(newr,newc));
                }
            }
        }
        return res;
    }
}