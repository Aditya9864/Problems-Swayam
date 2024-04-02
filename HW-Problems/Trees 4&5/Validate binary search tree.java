class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        tolist(root,li);
        for(int i=0;i<li.size()-1;i++)
        {
            if(li.get(i+1)<=li.get(i))
             return false;
        }
        return true;
    }
    void tolist(TreeNode root,List<Integer> li)
    {
        if(root==null)
         return;
        tolist(root.left,li);
        li.add(root.val);
        tolist(root.right,li);
    }
}