class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    int res=0;
    class child
    {
        int max,min,size;
        boolean isv;
        child(){};
        child(int min,int max,boolean t,int size)
        {
            this.min=min;
            this.max=max;
            this.isv=t;
            this.size=size;
        }
    }
    int largestBst(Node root)
    {
        // Write your code here
        findsize(root);
        return res;
    }
    child findsize(Node root)
    {
        if(root==null)
         return new child(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);

        child left=findsize(root.left);
        child right=findsize(root.right);
        child node=new child();
        node.min=Math.min(left.min,root.data);
        node.max=Math.max(right.max,root.data);

        if(root.data<=left.max || root.data>=right.min || !left.isv || !right.isv)
        {
            node.isv=false;
            node.size+=Math.max(left.size,right.size);
        }
        else
        {
            node.isv=true;
            node.size=left.size+right.size+1;
            res=Math.max(node.size,res);
        }
        return node;
    }
}
    
