class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    class Tuple
    {
        Node node;
        int row;
        Tuple(Node node,int row)
        {
            this.node=node;
            this.row=row;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q= new LinkedList<Tuple>();
        q.offer(new Tuple(root,0));
        while(!q.isEmpty())
        {
            Tuple t=q.poll();
            Node n=t.node;
            int x=t.row;
            
            if(map.containsKey(x))
             map.replace(x,n.data);
            else
             map.put(x,n.data);
             
            if(n.left != null)
             q.offer(new Tuple(n.left,x-1));
            if(n.right != null)
             q.offer(new Tuple(n.right,x+1));
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i:map.keySet())
         ans.add(map.get(i));
         
        return ans;
    }
}