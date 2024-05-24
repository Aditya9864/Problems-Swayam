class Solution {
    public int maxSubArray(int[] nums) {
        int curr=0,sum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            curr=curr+nums[i];
            sum=Math.max(sum,curr);
            if(curr < 0)
             curr=0;
        }
        return sum;
    }
}