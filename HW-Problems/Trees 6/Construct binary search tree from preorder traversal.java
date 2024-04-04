//USING approach discussed in class

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        if(n==0)
         return null;
        int inorder[]=new int[n];
        for(int i=0;i<n;i++)
            inorder[i]=preorder[i];
        Arrays.sort(inorder);
        TreeNode ans=buildbst(inorder, preorder, 0, n-1, 0, n-1);
        return ans;
    }
    TreeNode buildbst(int inorder[],int preorder[],int inStart,int inEnd, int preStart, int preEnd)
    {
        if(inStart>inEnd || preStart>preEnd)
         return null;

        TreeNode root=new TreeNode(preorder[preStart]);
        int i=-1;
        for(i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==root.val)
             break;
        }
        int countonleft=i-inStart;
        root.left=buildbst(inorder, preorder, inStart, i-1, preStart+1, preStart+countonleft);
        root.right=buildbst(inorder, preorder, i+1, inEnd, preStart+countonleft+1, preEnd);
        return root;
    }
}


// SOLUTION 2 - optimized complexity

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);
        for(int i: preorder)
        {
            helper(i,root);
        }
        return root ;
    }
    public TreeNode helper(int i, TreeNode root)
    { 
        if(root==null)
        {
            root=new TreeNode(i);
            return root;
        }
        if(i<root.val)
            root.left= helper(i,root.left);
        if(i>root.val)
            root.right=helper(i, root.right);
        return root;
    }
}