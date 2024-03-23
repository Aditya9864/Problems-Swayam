//RECURSIVE APPROACH
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {     
        if(p==null && q==null)
         return true;
        if(p==null || q==null)
         return false;
        if(p.val != q.val)
         return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}



//ITERATIVE APPROACH

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        Queue<TreeNode> pq= new LinkedList<>();
        Queue<TreeNode> qq= new LinkedList<>();
        pq.add(p);
        qq.add(q);

        while( !pq.isEmpty() || !qq.isEmpty())
        {   
            TreeNode pv=pq.poll();
            TreeNode qv=qq.poll();
            
            if( pv==null || qv==null)
             return false;
            if((pv!=null && qv!=null) && (pv.val != qv.val))
             return false;
            
            if(pv!=null)
            {
                pq.add(pv.left);
                pq.add(pv.right);
            }
            if(qv!=null)
            {
                qq.add(qv.left);
                qq.add(qv.right);
            }
        }
        return true;
    }
}