class Solution {
    TreeNode prev=null;
    TreeNode element1,element2;
    boolean element1found=false;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=element1.val;
        element1.val=element2.val;
        element2.val=temp;
    }
    void inorder(TreeNode root)
    {
        if(root==null)
         return;

        inorder(root.left);
        if(prev!=null)
        {
            if(root.val<prev.val && !element1found)
            {
                element1=prev;
                element1found=true;
                element2=root;
            }
            else if(root.val<=prev.val && element1found)
                element2=root;
        }
        prev=root;
        inorder(root.right);
    }
}