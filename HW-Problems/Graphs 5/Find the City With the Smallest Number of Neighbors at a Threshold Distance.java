class Solution {
    class Pair
    {
        int weight;
        int next;
        Pair(int weight,int next)
        {
            this.weight=weight;
            this.next=next;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj=new ArrayList();
         for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());
        for(int edge[]: edges)
        {
            adj.get(edge[0]).add(new Pair(edge[2],edge[1]) );
            adj.get(edge[1]).add(new Pair(edge[2],edge[0]) );
        }
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0; i<n; i++)
        {
            int reachablecities=dijkstra(n, adj, i, distanceThreshold);
            if(reachablecities<= min)
            {
                min=reachablecities;
                ans=i;
            }
        }
        return ans;
    }
    int dijkstra(int n, List<List<Pair>> adj, int src, int dT)
    {
        int answer[]=new int[n];
        Arrays.fill(answer,Integer.MAX_VALUE);
        boolean visited[]=new boolean[n];
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) ->a.weight - b.weight);
        
        pq.add(new Pair(0,src));
        answer[src]=0;
        int count=0;
        while(!pq.isEmpty())
        {
            Pair cnode=pq.poll();
            if(visited[cnode.next] || cnode.weight>dT)
             continue;
            
            visited[cnode.next]=true;
            answer[cnode.next]=cnode.weight;
            for(Pair neighbour : adj.get(cnode.next))
            {
                int nxt=neighbour.next;
                int wt=neighbour.weight;
                if(!visited[nxt])
                {
                    if(answer[nxt]>cnode.weight+wt && cnode.weight+wt <= dT) 
                       pq.add( new Pair(cnode.weight+wt , nxt));
                }
            }
            count++;
        }
        return count;
    }
}