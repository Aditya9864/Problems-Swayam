class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int low=0,high=nums.length-1;
        return buildbst(nums,low,high);
    }
    TreeNode buildbst(int nums[],int low,int high)
    {
        TreeNode root=null;
        if(low<=high)
        {
         int mid=(low+high)/2;
    
         root=new TreeNode(nums[mid]);
         root.left=buildbst(nums,low,mid-1);
         root.right=buildbst(nums,mid+1,high);
        }
        return root;
    }
}