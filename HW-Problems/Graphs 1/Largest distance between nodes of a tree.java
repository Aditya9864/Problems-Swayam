public class Solution {
    List<List<Integer>> adj;
    int depth[];
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        
        adj = new ArrayList<>();
        for(int i=0; i<n; i++) 
            adj.add(new ArrayList<>());

        int root=0;
        for(int i=0; i<n; i++) 
        {
            if(A.get(i)== -1) 
                root=i;
            else
            {
                adj.get(A.get(i)).add(i);
                adj.get(i).add(A.get(i));
            }
        }
        depth= new int[n];
        dfs(root, -1, 0);

        int diameter = diameterOfTree(root, -1);
        return diameter;
    }
    
    void dfs(int u, int parent,int d) 
    {
        depth[u] = d;
        for(int v : adj.get(u)) 
        {
            if(v != parent) 
                dfs(v, u, d + 1);  
        }
    }
    
    int diameterOfTree(int u, int parent) 
    {
        int maxD = 0;
        int d1=0, d2=0;
        for(int v : adj.get(u)) 
        {
            if(v != parent) 
            {
                int diameter = diameterOfTree(v, u);
                maxD= Math.max(maxD, diameter);
                int depthV=depth[v];
                if(depthV> d1) 
                {
                    d2 = d1;
                    d1 = depthV;
                } 
                else if(depthV > d2)
                    d2 = depthV;
            }
        }
        return Math.max(maxD, d1+d2);
    }
}
