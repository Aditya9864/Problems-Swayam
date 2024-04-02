class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> li= new ArrayList<Integer>();
        return findinList(root,li,k);
    }
    boolean findinList(TreeNode root,List<Integer> li,int k)
    {
        if(root==null)
         return false;

        if(li.contains(k-root.val))
         return true;
         li.add(root.val);
        return findinList(root.left,li,k) || findinList(root.right,li,k);
    }
}