//recursive solution

class Solution {
    static void findpath(TreeNode root,List<String> list,String str)
    {
        if(root==null)
         return;
        str=str+""+root.val;
        if(root.left==null && root.right==null)
        {
            list.add(str);
            return;
        }
        str=str+"->";
        findpath(root.left,list,str);
        findpath(root.right,list,str);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> li=new ArrayList<>();
        String s="";
        findpath(root,li,s);
        return li;
    }
}