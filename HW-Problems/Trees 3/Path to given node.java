public class Solution {
     List<Integer> ans=new ArrayList<Integer>();
    public int[] solve(TreeNode A, int B) {
        path(A,ans,B);
        int arr[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
         arr[i]=ans.get(i);
        return arr;
    }
    boolean path(TreeNode root,List<Integer> ans,int b)
    {
        if(root==null)
         return false;
        ans.add(root.val);
        if(root.val==b || path(root.left,ans,b) || path(root.right,ans,b))
         return true;
        
        ans.remove(ans.size()-1);
        return false;
    }
}
