class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)
         return 0;
        if(n==1)
         return nums[0];
        if(n==2) 
         return Math.max(nums[0], nums[1]);

        int dp1[]=new int[nums.length];
        int dp2[]=new int[nums.length];
        int max= -1;
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0], nums[1]);
        for(int i = 2; i< n- 1; i++)
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i++)
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
    
        for(int i=0; i<n; i++)
        {
            max=Math.max(max, dp1[i]);
            max=Math.max(max,dp2[i]);
        }
        return max;
    }
}