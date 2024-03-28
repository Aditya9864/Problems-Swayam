class Solution
{
	int getLevelDiff(Node root)
	{
	    //code here
        if(root == null)
         return 0;
        
        int odd=0,even=0;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        int level=1;
        while( !q.isEmpty())
        {
            int size=q.size();
            List<Integer> li=new ArrayList<Integer>();
            for(int i=0;i<size;i++)
            {
                Node n=q.poll();
                if(n.left !=null)
                 q.add(n.left);
                if(n.right != null)
                 q.add(n.right);
                 
                if(level%2!=0)
                 odd=odd+n.data;
                else
                 even=even+n.data;
            }
            level++;
        }
        return odd-even;
	}
}
