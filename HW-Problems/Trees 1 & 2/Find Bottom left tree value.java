class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> li=new ArrayList<Integer>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                li.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(li);
        }
        return res.get(res.size()-1).get(0);
    }
}