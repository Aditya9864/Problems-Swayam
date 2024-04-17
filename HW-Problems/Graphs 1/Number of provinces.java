class Solution {
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        visited=new boolean[n];
        int count=0;
        List<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
          adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                  adj[i].add(j); 
            }
        }
        for (int i=0; i<n; i++) 
        {
            if (!visited[i]) 
            {
                bfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }
    void bfs(List<Integer> adj[],int s,boolean visited[])
    {
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty())
        {
            s=q.poll();
            for (int i=0; i<adj[s].size(); i++) 
            {
                if(!visited[adj[s].get(i)])
                 q.offer(adj[s].get(i));
                visited[adj[s].get(i)] = true;
            }
        }
    }
}