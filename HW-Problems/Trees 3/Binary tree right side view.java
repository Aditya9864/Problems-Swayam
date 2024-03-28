class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null)
         return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        int level=1;
        map.put(level,root.val);
        while(!q.isEmpty())
        {
            int size=q.size();
            int val=0;
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null)
                 q.offer(node.left);
                if(node.right!=null)
                 q.offer(node.right);
                val=node.val;
            }
            map.put(level,val);
            level++;
        }
        for(int i:map.keySet())
         ans.add(map.get(i));
        return ans;
    }
}