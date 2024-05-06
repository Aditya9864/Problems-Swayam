class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        int indegree[]=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        int ans=0;
        for(int i=0 ;i<n;i++) 
            adj.add(new ArrayList<Integer>());

        for(int edge[]:edges) 
        {
            indegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
        }

        int map[][]=new int[n][26];
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0 ; i<indegree.length; i++) 
        {
            if(indegree[i]==0) 
            {
                q.add(i);
                map[i][colors.charAt(i)-'a']=1;
            }
        }
        int count=0;
        while(!q.isEmpty()) 
        {
            count++;
            int num=q.poll();
            ans=Math.max(ans, map[num][colors.charAt(num)-'a']);
            for(Integer k: adj.get(num)) 
            {
                for(int i=0;i<26;i++) 
                {
                    int temp=map[num][i];
                    if(colors.charAt(k)-'a'==i) 
                        temp++;
            
                    map[k][i]=Math.max(temp,map[k][i]);
                }
                indegree[k]--;
                if(indegree[k]==0) 
                    q.add(k);
            }
        }
        return count!= n? -1:ans;
    }
}