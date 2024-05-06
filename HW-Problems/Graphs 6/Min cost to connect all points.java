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

    class Tuple
    {
        int u;
        int v;
        int weight;

        Tuple(int u, int v, int weight) 
        {
            this.u=u;
            this.v= v;
            this.weight = weight;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Tuple> edges = new PriorityQueue<>( (a,b)->a.weight-b.weight );
        for(int i=0; i<n; i++) 
        {
            for(int j=i+1; j<n; j++) 
            {
                int cost =Math.abs( points[i][0]-points[j][0] ) + Math.abs( points[i][1]-points[j][1] );
                edges.add(new Tuple(i, j, cost));
            }
        }

        DSU dsu = new DSU(n);
        int cost=0;
        int connected=0;

        while( !edges.isEmpty() && connected < n-1) 
        {
            Tuple edge=edges.poll();
            boolean isPossible= dsu.union(edge.u, edge.v);
            if(isPossible) 
            {
                cost+=edge.weight;
                connected++;
            }
        }
        return cost;
    }
}