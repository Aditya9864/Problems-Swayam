class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int d[]=new int[1];
        depth(root,d);
        return d[0];
    }
    int depth(TreeNode root, int[] diameter) 
    {
        if (root == null)
           return 0;
        int lh = depth(root.left, diameter);
        int rh = depth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1+Math.max(lh,rh); 
    }
}