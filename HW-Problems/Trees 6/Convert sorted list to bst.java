class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
         return null;
        
        TreeNode r=buildbst(head,null);
        return r;
    }
    ListNode findmiddle(ListNode low,ListNode high)
    {
        ListNode slow=low;
        ListNode fast=low;
        while(fast != high && fast.next != high){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    TreeNode buildbst(ListNode low, ListNode high)
    {
        if(low==high)
         return null;
        ListNode mid=findmiddle(low,high);
        TreeNode node=new TreeNode(mid.val);
        node.left=buildbst(low,mid);
        node.right=buildbst(mid.next,high);
        return node;
    }
}