class Solution {
    class DSU
    {
        int parent[];
        int rank[];
        DSU(int numNodes)
        {
            rank=new int[numNodes];
            parent=new int[numNodes];
            for(int i=0;i<numNodes;i++)
            {
                parent[i]=i;
                rank[i]=1;
            }
        }
        int findparent(int node)
        {
            if(node==parent[node])
             return node;

            int p=findparent(parent[node]);
            parent[node]=p;
            return p;
        }
        boolean union(int u,int v)
        {
            int p1=findparent(u);
            int p2=findparent(v);
            if(p1==p2)
             return false;
            
            if(rank[p1]>rank[p2])
            {
                parent[p2]=p1;
                rank[p1]+= rank[p2];
            }
            else
            {
                parent[p1]=p2;
                rank[p2]+=rank[p1];
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu= new DSU(n+1);
        for(int edge[] : edges)
        {
            boolean isPossible= dsu.union(edge[0],edge[1]);
            if(!isPossible)
             return edge;
        }
        return edges[0];
    }
}