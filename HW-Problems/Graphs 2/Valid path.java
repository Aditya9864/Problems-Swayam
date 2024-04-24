public class Solution {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        boolean visited[][] = new boolean[A+1][B+1];
        visited[0][0] = true;
        int directions[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) 
        {
            int curr[] =q.poll();
            for (int dir[]: directions) 
            {
                int row= curr[0] + dir[0];
                int col= curr[1] + dir[1];
                if(row >= 0 && row <= A && col >= 0 && col <= B && !visited[row][col]) 
                {
                    if(isValid(row, col,C, D, E, F))
                    {
                      visited[row][col]=true;
                      q.offer(new int[]{row,col});
                    }
                }
            }
        }
        if(visited[A][B])
         return "YES";
        
        return "NO";
    }
    
    boolean isValid(int row, int col,int C,int D, ArrayList<Integer> E, ArrayList<Integer> F) 
    {
        for(int i= 0; i<C; i++) 
        {
            if(Math.pow(E.get(i) - row, 2) + Math.pow(F.get(i) -col, 2) <= D*D)
                return false;
        }
        return true;
    }
}
