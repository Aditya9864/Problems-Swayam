class Solution {
    public int jump(int[] nums) {
        int rindex=0,rsteps=0,steps=0;
        if(nums.length==1)
         return 0;
        for(int i=0;i<nums.length;i++)
        {
            rindex=Math.max(rindex,nums[i]+i);
            if(rsteps==i)
            {
                steps++;
                rsteps=rindex;
            }
            if(rsteps >= nums.length-1)
             return steps;
        }
        return steps;
    }
}