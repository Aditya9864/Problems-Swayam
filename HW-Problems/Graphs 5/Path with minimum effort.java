class Solution {
    class Pair implements Comparable <Pair>
    {
        int i;
        int j;
        int rem;
        Pair(int i, int j, int rem)
        {
            this.i = i;
            this.j = j;
            this.rem = rem;
        }
        public int compareTo(Pair b)
        {
            return this.rem - b.rem;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int dir[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean visited[][] = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int diff[][]= new int[n][m];
        for (int row[] : diff) 
            Arrays.fill(row, Integer.MAX_VALUE);

        pq.add(new Pair(0, 0, 0));
        diff[0][0] = 0;
                
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            int i=curr.i;
            int j=curr.j;

            if(i==n-1 && j==m-1)
                return curr.rem;

            visited[i][j] = true;
            for(int k=0; k<4; k++)
            {
                int x= i + dir[k][0];
                int y= j + dir[k][1];

                if( x<0 || x==n || y<0 || y==m ||visited[x][y])
                    continue;
        
                int rightnow= Math.abs(heights[i][j] - heights[x][y]);
                int maxD=Math.max(diff[i][j], rightnow);
                if(diff[x][y] > maxD)
                {
                    diff[x][y] = maxD;
                    pq.add(new Pair(x, y, maxD));
                }
            }
        }
        return diff[n-1][m-1];
    }
}