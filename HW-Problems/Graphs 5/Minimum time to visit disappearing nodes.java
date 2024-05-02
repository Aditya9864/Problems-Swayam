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
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int answer[]=new int[n];
        Arrays.fill(answer,Integer.MAX_VALUE);
        List<List<Pair>> adj=new ArrayList();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());

        boolean visited[]=new boolean[n];
        for(int edge[]: edges)
        {
            adj.get(edge[0]).add(new Pair(edge[2],edge[1]) );
            adj.get(edge[1]).add(new Pair(edge[2],edge[0]) );
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->{ return a.weight - b.weight;});
        pq.add(new Pair(0,0));
        answer[0]=0;
    
        while(!pq.isEmpty())
        {
            Pair cnode=pq.poll();
            if(visited[cnode.next] || cnode.weight>=disappear[cnode.next])
             continue;
            
            visited[cnode.next]=true;
            answer[cnode.next]=cnode.weight;
            for(Pair neighbour : adj.get(cnode.next))
            {
                int nxt=neighbour.next;
                int wt=neighbour.weight;
                if(!visited[nxt])
                {
                    if(answer[nxt]>cnode.weight+wt && cnode.weight+wt < disappear[nxt]) 
                       pq.add( new Pair(cnode.weight+wt , nxt));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(answer[i]==Integer.MAX_VALUE)
             answer[i]=-1;
        }
        return answer;
    }
}