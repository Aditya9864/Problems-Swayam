class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum=0;
        return paths(root,sum,targetSum);
    }
    static boolean paths(TreeNode root,int sum,int t)
    {
        if(root==null)
         return false;
        sum=sum+root.val;
        if(root.left==null && root.right==null && sum==t)
         return true;
        
        return paths(root.left,sum,t) || paths(root.right,sum,t);
    }
}