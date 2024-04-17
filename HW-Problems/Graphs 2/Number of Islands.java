class Solution {
    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    void dfs(char map[][],int i,int j)
    {
        if(i<0 || j<0 || i>=map.length || j>=map[0].length)
          return;
        if(map[i][j]!='1')
          return;
        map[i][j]='*';
        for(int[] dir:directions)
        {
            int newr=i+dir[0];
            int newc=j+dir[1];
            dfs(map,newr,newc);
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
}