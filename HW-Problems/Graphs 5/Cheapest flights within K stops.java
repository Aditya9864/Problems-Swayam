class Solution {
    class Pair
    {
        int weight;
        int next;
        int stops;
        Pair(int weight,int next)
        {
            this.weight=weight;
            this.next=next;
        }
    }

    class PairFl
    {
        int weight;
        int next;
        int stops;
        PairFl(int weight,int next,int stops)
        {
            this.weight=weight;
            this.next=next;
            this.stops=stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int answer[]=new int[n];
        Arrays.fill(answer,Integer.MAX_VALUE);
        List<List<Pair>> adj=new ArrayList();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());

        for(int edge[]: flights)
            adj.get(edge[0]).add(new Pair(edge[2],edge[1]) );

        PriorityQueue<PairFl> pq= new PriorityQueue<>((a,b)->a.weight - b.weight);
        pq.add(new PairFl(0,src,0));
        answer[src]=0;
    
        while(!pq.isEmpty())
        {
            PairFl cnode=pq.poll();
            if(cnode.next==dst || cnode.stops>k)
             continue;
            
            for(Pair neighbour : adj.get(cnode.next))
            {
                int nxt=neighbour.next;
                int wt=neighbour.weight;
                if(answer[nxt]>=cnode.weight+wt)
                {
                    answer[nxt]=cnode.weight+wt;
                    pq.add( new PairFl(cnode.weight+wt , nxt, cnode.stops+1));
                }          
            }
        }
        return answer[dst]==Integer.MAX_VALUE? -1 : answer[dst];
    }
}