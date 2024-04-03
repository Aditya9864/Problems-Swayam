class Tree {
    // Function to return the ceil of given number in BST.
    int ans=Integer.MAX_VALUE;
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        check(root,key);
        if(ans==Integer.MAX_VALUE)
         return -1;
        return ans;
    }
    void check(Node root,int key)
    {
        if(root==null)
         return;
         
        if(root.data==key)
          ans=root.data;
        else if(root.data>key)
        {
          if(root.data<ans)
           ans=root.data;
          check(root.left,key);
        }
        else
          check(root.right,key);
    }
}