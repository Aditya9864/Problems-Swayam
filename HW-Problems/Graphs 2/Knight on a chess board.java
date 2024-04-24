public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        return bfs(A,B,C,D,E,F);
    }
    int bfs(int A,int B,int C,int D,int E,int F)
    {
        boolean visited[][]=new boolean[A][B];
        int directions[][]={{1,2},{-1,-2},{-1,2},{1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        Queue<int []> q=new LinkedList();
        q.offer(new int[]{C-1,D-1,0});
        visited[C-1][D-1]=true;
        while(!q.isEmpty())
        {
            int a[]=q.poll();
            if(a[0]==E-1 && a[1]==F-1)
             return a[2];
            for(int dir[]:directions)
            {
                int row=a[0]+dir[0];
                int col=a[1]+dir[1];
                
                if(row<0 || col<0 || row>=A || col>=B || visited[row][col])
                continue;
                
                visited[row][col]=true;
                q.offer(new int[]{row,col,a[2]+1});
            }
        }
        return -1;
    }
}
