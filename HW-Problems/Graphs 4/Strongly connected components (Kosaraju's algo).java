class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int count=0;
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++) 
        {
            if (!visited[i])
                dfs(i, s, visited, adj);
        }
        
        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < V; i++)
            rev.add(new ArrayList<>());

        for(int src=0; src<V; src++) 
        {
            for(int neigh: adj.get(src)) 
                rev.get(neigh).add(src);
        }
       // s.clear();
        while(!s.isEmpty()) 
        {
            int top = s.pop();
            if(!visited[top]) 
            {
                dfs(top, s,visited, rev);
                count++;
            }
        }
        return count;
    }
    public void dfs(int src, Stack<Integer> s, boolean visited[], ArrayList<ArrayList<Integer>> adj) 
    {
        visited[src]=true;
        for(int neigh: adj.get(src)) 
        {
            if(!visited[neigh])
                dfs(neigh,s, visited, adj);
        }
        s.push(src);
    }
}
