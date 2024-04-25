class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        boolean dfs[] = new boolean[V];
        boolean ans = false;

        for (int i = 0; i<V; i++) 
        {
            if(!visited[i])
            {
                ans=check(adj,i,visited,dfs, ans);
                if(ans) 
                 return true;
            }
        }
        return false;
    }
    boolean check(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] visited, boolean[] dfs, boolean ans)
    {
        visited[curr]=true;
        dfs[curr]=true;
        for(int i = 0; i<adj.get(curr).size(); i++) 
        {
            int neighbour =adj.get(curr).get(i);
            if (!visited[neighbour])
            {
                ans=check(adj,neighbour, visited,dfs,ans);
                if(ans)
                 return true;
            } 
            else if (dfs[neighbour]) 
                return true; 
        }
        dfs[curr] = false;
        return false;
    }
}

