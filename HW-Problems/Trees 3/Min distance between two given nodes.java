class GfG {
    public Node lca(Node root, int p, int q) 
    {
        if(root == null || root.data == p || root.data == q) 
         return root;
        
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        if(left != null && right != null) 
         return root;
        else if(left != null) 
         return left;
        else
        return right;
    } 
    int findDist(Node root, int a, int b) {
        // Your code here
        Node l=lca(root,a,b);
        
        return finddist(l,a,0)+finddist(l,b,0);
    }
    int finddist(Node root,int x,int dist)
    {
        if(root==null)
         return -1;
        
        if(root.data==x)
         return dist;
        
        int lt = finddist(root.left, x, dist + 1);
        int rt = finddist(root.right, x, dist + 1);
        if (lt > rt) 
          return lt;
        else 
          return rt;
    }
}