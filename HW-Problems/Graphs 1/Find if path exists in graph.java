class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
          adj[i]=new ArrayList<>();
        for(int edge[]:edges) 
        {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return bfs(adj,n,source,destination);
    }
    boolean bfs(List<Integer> adj[],int n, int s, int d)
    {
        boolean visited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty())
        {
            s=q.poll();
            if(s==d)
             return true;
            
            for(int i=0 ; i<adj[s].size() ;i++)
            {
                if(adj[s].get(i)==d)
                 return true;
                
                if(visited[adj[s].get(i)]==false)
                {
                    q.offer(adj[s].get(i));
                    visited[adj[s].get(i)]=true;
                }
            }
        }
        return false;
    }
}