class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    List<Integer> li=new ArrayList<Integer>();
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        inorder(root1);
        inorder(root2);
        Collections.sort(li);
        return li;
    }
    void inorder(Node root)
    {
        if(root==null)
         return;
        
        inorder(root.left);
        li.add(root.data);
        inorder(root.right);
    }
}
