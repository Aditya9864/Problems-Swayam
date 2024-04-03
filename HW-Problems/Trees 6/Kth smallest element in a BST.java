class Solution {
    int count,ans;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inorder(root);
        return ans;
    }
    void inorder(TreeNode root) 
    {
        if(root==null)
         return;

        inorder(root.left);
        count--;
        if(count == 0) 
        {
          ans=root.val;
          return;
        }
        inorder(root.right);
    }
}