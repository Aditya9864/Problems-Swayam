import java.util.*;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> res=new ArrayList<>();
       if(root==null)
        return null;
       if(isleaf(root))
        return res;
       
       res.add(root.data);
       left(root.left,res);
       addleave(root,res);
       right(root.right,res);
       return res;
    }
    static boolean isleaf(TreeNode root)
    {
        return (root.left==null && root.right==null);
    }
    static void addleave(TreeNode root,List<Integer> res)
    {
        if(isleaf(root))
        {
            res.add(root.data);
            return;
        }
        if(root.left!=null)
          addleave(root.left,res);
        if(root.right!=null)
          addleave(root.right,res);
    }
    static void left(TreeNode root,List<Integer> res)
    {
        TreeNode curr=root;
        while(curr!=null)
        {
            if(!isleaf(curr))
             res.add(curr.data);

            if(curr.left!=null)
             curr=curr.left;
            else
             curr=curr.right;
        }
    }
    static void right(TreeNode root,List<Integer> res)
    {
        TreeNode curr=root;
        List<Integer> temp=new ArrayList<>();
        while(curr!=null)
        {
            if(!isleaf(curr))
             temp.add(curr.data);

            if(curr.right!=null)
              curr=curr.right;
            else
              curr=curr.left;
        }
        Collections.reverse(temp);
        for(int i:temp)
         res.add(i);
    }
}