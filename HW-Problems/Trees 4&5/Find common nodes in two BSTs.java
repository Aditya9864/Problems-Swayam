class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //code here
        ArrayList<Integer> r1=new ArrayList<Integer>();
        ArrayList<Integer> r2=new ArrayList<Integer>();
        inorder(root1,r1);
        inorder(root2,r2);
        for(int i=0;i<r1.size();i++)
        {
            if( !r2.contains(r1.get(i)) )
            {
             r1.remove(r1.get(i));
             i--;
            }
        }
        return r1;
    }
    static void inorder(Node root,ArrayList<Integer> li)
    {
        if(root==null)
         return;
        
        inorder(root.left,li);
         li.add(root.data);
        inorder(root.right,li);
    }
}