import java.util.*;
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        List<Integer> ans= new ArrayList();
        solve(root,ans,0);
        for(int i:ans)
         System.out.print(i+" ");
    }
    static void solve(TreeNode<Integer> root ,List<Integer> ans,int level)
    {
        if(root==null)
         return;
         
        if(level == ans.size())
            ans.add(root.data);
        
        solve(root.left,ans,level+1);
        solve(root.right,ans,level+1);
    }
}
