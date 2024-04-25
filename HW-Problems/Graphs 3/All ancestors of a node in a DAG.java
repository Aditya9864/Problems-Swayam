class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> adj[]=new ArrayList[n];
        List<TreeSet<Integer>> ancestors = new ArrayList();
        for(int i=0; i<n; i++)
        {
            ancestors.add(new TreeSet<>());
            adj[i]=new ArrayList<>();
        }
        int indegree[]=new int[n];
        for(int edge[]:edges)
        {
            indegree[edge[1]]++;
            adj[edge[0]].add(edge[1]);
        }
        addanc(adj,indegree,ancestors,n);
        
        for(TreeSet<Integer> set: ancestors)
            ans.add(new ArrayList<Integer>(set));

        return ans;
    }
    void addanc(List<Integer> adj[],int indegree[],List<TreeSet<Integer>> ancestors,int n)
    {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
         while(!q.isEmpty())
        {
            int curr=q.poll();
            for(int node: adj[curr])
            {
                ancestors.get(node).addAll(new TreeSet(ancestors.get(curr)));
                ancestors.get(node).add(curr);

                indegree[node]--;
                if(indegree[node] == 0)
                    q.add(node);
            }
        }
    }
}