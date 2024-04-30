class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int a[]=new int[n];
        if(n==1)
         return nums[0];
        a[0]=nums[0];
        a[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++)
        {
            a[i]=Math.max(a[i-1], a[i-2]+nums[i]);
        }
        return a[n-1];
    }
}