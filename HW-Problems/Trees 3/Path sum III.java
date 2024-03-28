class Solution {
    int count=0;
    int t;
    Map<Integer,Integer> map= new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        t=targetSum;
        map.put(0,1);
        findpath(root,0);
        return count;
    }
    public void findpath(TreeNode root,int sum)
    {
        if(root==null)
         return;

        sum=sum+root.val;
        if(map.containsKey(sum-t))
            count=count+ map.get(sum-t);
            
        map.put(sum, map.getOrDefault(sum,0)+1);
        findpath(root.left,sum);
        findpath(root.right,sum);
        if(map.get(sum)==1)
         map.remove(sum);
        else
         map.put(sum,map.get(sum)-1);
    }
}