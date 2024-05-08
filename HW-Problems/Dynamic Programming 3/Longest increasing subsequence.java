/*   RECURSION -
class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(nums,0, -1);
    }
    int solve(int[] nums, int curr, int prev) 
    {
        if (curr >= nums.length) 
            return 0;

        int take = 0;
        if (prev== -1 || nums[prev]< nums[curr]) 
            take =1 + solve(nums, curr+1, curr);

        int nottake = solve(nums, curr+1, prev);
        return Math.max(take, nottake);
    }
}*/


/* RECURSION+MEMO -
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int cache[][] = new int[n + 1][n + 1];
        for (int row[] : cache)
            Arrays.fill(row, -1);
    
        return solve(nums,0, -1,cache);
    }
    int solve(int[] nums, int curr, int prev, int cache[][]) 
    {
        if (curr >= nums.length) 
            return 0;
        
        if (cache[curr][prev+1] != -1) 
            return cache[curr][prev + 1];

        int take = 0;
        if (prev== -1 || nums[prev]< nums[curr]) 
            take =1 + solve(nums, curr+1, curr, cache);

        int nottake = solve(nums, curr+1, prev, cache);
        return cache[curr][prev + 1] = Math.max(take, nottake);
    }
}*/


/*  DP-
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1; i<n; i++)
        {
            int maxprev=0;
            for(int j=0; j<=i-1 ;j++)
            {
                if(nums[i] > nums[j])
                 maxprev=Math.max(maxprev, dp[j]);
            }
            dp[i]=maxprev+1;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}*/


// BINARY SEARCH-
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> lis=new ArrayList<>();
        lis.add(nums[0]);

        for(int i=1; i<n; i++) 
        {
            if(nums[i] >lis.get(lis.size()-1))
                lis.add(nums[i]);
            else
            {
                int idx=bins(lis,nums[i]);
                lis.set(idx,nums[i]);
            }
        }
        return lis.size();
    }
    int bins(List<Integer> lis, int x)
    {
        int low=0;
        int high=lis.size()-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(lis.get(mid)==x)
             return mid;
            else if(lis.get(mid) < x)
             low=mid+1;
            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}