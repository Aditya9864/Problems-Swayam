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
    public int minSwapsCouples(int[] row) {
        int n=row.length;
        int couples= n/2;
        DSU dsu = new DSU(couples);
        int swaps=0;
        for(int i = 0; i < couples; i++)
        {
            int a=row[i*2];
            int b=row[i*2 + 1];

            int Pa= dsu.findparent(a/2);
            int Pb= dsu.findparent(b/2);
            if(Pa == Pb)
             continue;
            
            boolean isPossible = dsu.union(a/2 , b/2);
            //if(isPossible)
            swaps++;
        }   
        return swaps;
    }
}