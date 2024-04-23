class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++)
         map.put(i,new ArrayList<>());

        for (int edge[] : prerequisites) 
        {
            indegree[edge[0]]++;
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int completed=0;

        for(int i = 0; i<numCourses; i++) 
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
        if(completed==numCourses)
         return true;
        
        return false;
    }
}