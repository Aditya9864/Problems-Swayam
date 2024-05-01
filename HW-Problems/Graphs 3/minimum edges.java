class Solution {
    static class Pair
    {
        int next;
        int weight;
        Pair(int next,int weight)
        {
            this.next=next;
            this.weight=weight;
        }
    }
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int edge[]:edges)
        {
            adj.get(edge[0]).add(new Pair(edge[1],0));
            adj.get(edge[1]).add(new Pair(edge[0],1));
        }
        
        Deque<Integer> dq=new ArrayDeque<Integer>();
        int required[]=new int[n+1];
        //boolean visited[]=new boolean[n+1];
        Arrays.fill(required,Integer.MAX_VALUE);
        
        required[src]=0;
        //visited[src]=true;
        dq.add(src);
        
        while(!dq.isEmpty())
        {
            int node=dq.poll();
            for(int i=0; i<adj.get(node).size(); i++)
            {
                Pair temp=adj.get(node).get(i);
                
                if(required[temp.next]> required[node]+temp.weight )
                {
                    //visited[temp.next]=true;
                    required[temp.next]= required[node]+temp.weight;
                    
                    if(temp.weight==0)
                      dq.addFirst(temp.next);
                    else
                      dq.addLast(temp.next);
                }
            }
        }
        return required[dst]==Integer.MAX_VALUE?-1:required[dst];
    }
}
        
