class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        List<Integer> ans= new ArrayList<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++)
         map.put(i,new ArrayList<>());

        for(int edge[] : prerequisites) 
        {
            indegree[edge[0]]++;
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int completed=0;

        for(int i=0; i<numCourses; i++) 
        {
            if(indegree[i]==0) 
            {
                q.add(i);
                completed++;
            }
        }

        while(!q.isEmpty()) 
        {
            int curr = q.poll();
            ans.add(curr);
            List<Integer> currdependent= map.get(curr);
            if (currdependent != null) 
            {
                for (int dependentCourse : currdependent) 
                {
                    indegree[dependentCourse]--;
                    if (indegree[dependentCourse] == 0) 
                    {
                        q.add(dependentCourse);
                        completed++;
                    }
                }
            }
        }
        if(completed != numCourses)
         return new int[0];

        int res[]=new int[numCourses];
        for(int i=0;i<ans.size();i++)
         res[i]=ans.get(i);

        return res;
    }
}