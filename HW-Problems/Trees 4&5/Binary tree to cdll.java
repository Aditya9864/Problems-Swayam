class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node prev=null,head=null;
    Node bTreeToClist(Node root)
    {
        //your code here
        if(root==null)
          return null;
        
        bTreeToClist(root.left);
        if(prev==null)
          head=root;
        else
        {
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        bTreeToClist(root.right);
        prev.right=head;
        head.left=prev;
        return head;
    }
}