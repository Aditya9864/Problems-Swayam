class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> li=new ArrayList<>();
        paths(root,ans,li,0,targetSum);
        return ans;
    }
    static void paths(TreeNode root,List<List<Integer>> ans,List<Integer> li,int sum,int t)
    {
        if(root==null)
         return;
        t=t-root.val;
        li.add(root.val);
        if(root.left==null && root.right==null && t==sum)
        {
            ans.add(new ArrayList<>(li));
        }
        else
        {
         paths(root.left,ans,li,sum,t);
         paths(root.right,ans,li,sum,t);
        }
        li.remove(li.size()-1);
    }
}