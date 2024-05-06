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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int remove=0;
        int alice=0, bob=0;
        DSU al= new DSU(n+1);
        DSU bo= new DSU(n+1);
        for(int edge[]:edges)
        {
            if(edge[0]==3)
            {
                if(al.union(edge[1],edge[2]))
                {
                   bo.union(edge[1], edge[2]);
                   bob++;
                   alice++;
                }
                else 
                  remove++;
            }
        }
        for(int edge[] : edges)
        {
            if(edge[0]== 1)
            {
               if(al.union(edge[1],edge[2]))
                alice++;
               else 
                 remove++;
            }
            if(edge[0]==2)
            {
                if(bo.union(edge[1],edge[2]))
                  bob++;
                else 
                  remove++;
            }
        }
        return (bob== n-1 && alice == n-1)?remove : -1;
    }
}