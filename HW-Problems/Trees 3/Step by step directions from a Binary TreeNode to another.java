class Solution {
    public String getDirections(TreeNode root,int startValue, int destValue) {
        StringBuilder l=new StringBuilder();
        StringBuilder r=new StringBuilder();
        StringBuilder ans= new StringBuilder();
        TreeNode LCA=lca(root,startValue,destValue);
        getPath(LCA,l,startValue);
        getPath(LCA,r,destValue);

        for(int i=0;i<l.length();i++)
         ans.append('U');
        
        ans.append(r);
        return ans.toString();
    }
    boolean getPath(TreeNode root, StringBuilder s, int t)
    {
        if(root == null)
         return false;
        if(root.val==t)
         return true;
        
        s.append('L');
        if(getPath(root.left,s,t))
          return true;
        s.deleteCharAt(s.length()-1);
                    
        s.append('R');
        if(getPath(root.right,s,t))
         return true;
        s.deleteCharAt(s.length()-1);

        return false;
    }
     TreeNode lca(TreeNode root, int p, int q)
    {
        if(root == null || root.val == p || root.val == q) 
         return root;
        
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left != null && right != null) 
         return root;
        else if(left != null) 
         return left;
        else
        return right;
    }
}