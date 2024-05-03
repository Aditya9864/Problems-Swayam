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
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        int indegree[]=new int[n+1];
        Arrays.fill(indegree,-1);
        DSU dsu= new DSU(n+1);
        int discard1=-1;
        int discard2=-2;
        for(int i=0;i<n;i++)
        {
            int edge[]=edges[i];
            if(indegree[edge[1]] ==-1)
             indegree[edge[1]]=i;
            else
            {
                discard1=i;
                discard2=indegree[edge[1]];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(i==discard1)
             continue;
            
            int edge[]=edges[i];
            boolean isPossible= dsu.union(edge[0],edge[1]);
            if(!isPossible)
            {
                if(discard1==-1)
                 return edge;
                else
                 return edges[discard2];
            }
        }
        return edges[discard1];
    }
}