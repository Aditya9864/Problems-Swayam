class Solution {
    int res=0;
    class child
    {
        int max,min,sum;
        boolean isv;
        child(){};
        child(int min,int max,boolean t,int sum)
        {
            this.min=min;
            this.max=max;
            this.isv=t;
            this.sum=sum;
        }
    }
    child findsum(TreeNode root)
    {
        if(root==null)
         return new child(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);

        child left=findsum(root.left);
        child right=findsum(root.right);
        child node=new child();
        node.min=Math.min(left.min,root.val);
        node.max=Math.max(right.max,root.val);

        if(root.val<=left.max || root.val>=right.min || !left.isv || !right.isv)
        {
            node.isv=false;
            node.sum+=Math.max(left.sum,right.sum);
        }
        else
        {
            node.isv=true;
            node.sum=left.sum+right.sum+root.val;
            res=Math.max(node.sum,res);
        }
        //if(root.val==Integer.MAX_VALUE || root.val==Integer.MIN_VALUE)
         //node.isv=true;
        return node;
    }
    public int maxSumBST(TreeNode root) {
        findsum(root);
        return res;
    }
}