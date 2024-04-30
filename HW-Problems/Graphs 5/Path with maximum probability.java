class Solution {
    class Pair
    {
        double weight;
        int node;
        Pair(double weight,int node)
        {
            this.weight=weight;
            this.node=node;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double dist[]=new double[n];
        List<List<Pair>> adj=new ArrayList();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
         dist[i]=Integer.MIN_VALUE;
         adj.add(new ArrayList());
        }

        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(new Pair(succProb[i],b));
            adj.get(b).add(new Pair(succProb[i],a));
        }

        dist[start_node]=1.0;

        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->((Double)y.weight).compareTo((Double)x.weight));
        pq.add(new Pair(1.0,start_node));

        while(!pq.isEmpty())
        {
            Pair cnode=pq.poll();
            if(visited[cnode.node])
             continue;

            visited[cnode.node]=true;
            dist[cnode.node]=cnode.weight;

            for(Pair neighbour : adj.get(cnode.node))
            {
                int neighNode=neighbour.node;
                double prob=neighbour.weight;

                if(visited[neighNode]) 
                  continue;
                pq.add( new Pair(cnode.weight*prob , neighNode));
            }
        } 

        return (dist[end_node]==Integer.MIN_VALUE? 0 : dist[end_node]);       
    }
}