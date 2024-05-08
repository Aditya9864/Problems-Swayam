//RECURSION
class Solution {
    public int jump(int[] nums) {
        int n=nums.length-1;
        return find(0, n, nums);
    }
    int find(int i, int n, int nums[])
    {
        if(i>=n)
         return 0;
        int min=n;
        for(int k=1; k<=nums[i]; k++)
        {
            int jumps= find(i+k, n, nums)+1;
            min=Math.min(jumps,min);
        }
        return min;
    }
}


//MEMOIZATION
class Solution {
    int cache[];
    public int jump(int[] nums) {
        int n=nums.length-1;
        cache=new int[n+1];
        Arrays.fill(cache,-1);
        return find(0, n, nums);
    }
    int find(int i, int n, int nums[])
    {
        if(i>=n)
         return 0;
        if(cache[i] != -1)
         return cache[i];

        int min=n;
        for(int k=1; k<=nums[i]; k++)
        {
            int jumps= find(i+k, n, nums)+1;
            min=Math.min(jumps,min);
        }
        cache[i]=min;
        return cache[i];
    }
}


//DP
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
