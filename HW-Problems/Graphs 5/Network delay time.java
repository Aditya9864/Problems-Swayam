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
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans[]=new int[n+1];
        int mini=-1;
        Arrays.fill(ans,Integer.MAX_VALUE);
        List<List<Pair>> adj=new ArrayList();
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<Pair>());

        boolean visited[]=new boolean[n+1];
        for(int edge[]: times)
        {
            adj.get(edge[0]).add(new Pair(edge[2],edge[1]) );
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.weight - b.weight);
        pq.add(new Pair(0,k));
        ans[k]=0;
    
        while(!pq.isEmpty())
        {
           Pair cnode=pq.poll();
           if(cnode.weight>ans[cnode.next] || visited[cnode.next])
             continue;
            
            visited[cnode.next]=true;
            ans[cnode.next]=cnode.weight;
            for(Pair neighbour : adj.get(cnode.next))
            {
                int nxt=neighbour.next;
                int wt=neighbour.weight;
                if(ans[nxt]>cnode.weight+wt)
                {
                    ans[nxt]=cnode.weight+wt;
                    pq.add( new Pair(cnode.weight+wt , nxt));
                }
            }
        }
        for(int i=1;i<n+1;i++)
            mini=Math.max(mini,ans[i]);

        return mini==Integer.MAX_VALUE? -1:mini;
    }
}