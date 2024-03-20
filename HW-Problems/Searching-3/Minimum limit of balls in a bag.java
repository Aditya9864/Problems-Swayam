class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1,high=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
         high=Math.max(high,nums[i]);
        while(low<high)
        {
            int mid=(high+low)/2;
            if(canPut(nums,mid,maxOperations))
             high=mid;
            else
             low=mid+1;
        }
        return low;
    }
    public boolean canPut(int[] nums,int mid,int max)
    {
        for(int i=0;i<nums.length;i++)
        {
            int t=nums[i];
            if(t%mid==0)
             max=max- ((t/mid)-1);
            else
             max=max- (t/mid);
            if(max<0)
              return false;
        }
        return true;
    }
}