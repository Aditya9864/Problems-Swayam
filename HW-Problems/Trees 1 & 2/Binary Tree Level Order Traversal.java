class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root == null)
         return res;
        
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while( !q.isEmpty())
        {
            int size=q.size();
            List<Integer> li=new ArrayList<Integer>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left !=null)
                 q.add(node.left);
                if(node.right != null)
                 q.add(node.right);

                li.add(node.val);
            }
            res.add(li);
        }
        return res;
    }
}