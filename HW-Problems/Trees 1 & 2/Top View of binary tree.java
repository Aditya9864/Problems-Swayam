class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Tuple
    {
        Node node;
        int row;
        Tuple(Node node,int row)
        {
            this.node=node;
            this.row=row;
        }
    }
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<Tuple>();
        
        q.offer(new Tuple(root,0));
        while(!q.isEmpty())
        {
            Tuple t=q.poll();
            Node n=t.node;
            int x=t.row;
            
            map.putIfAbsent(x,n.data);
            
            if(n.left !=null)
             q.offer(new Tuple(n.left,x-1));
            if(n.right !=null)
             q.offer(new Tuple(n.right,x+1));
        }
        ArrayList<Integer> ans= new ArrayList<>();
        for(int x:map.keySet())
        {
            ans.add(map.get(x));
        }
        return ans;
    }
}