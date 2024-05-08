//BOTTOM-UP
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
        for(int i=2; i< n-1; i++)
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
            
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++)
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
    
        for(int i=0; i<n; i++)
        {
            max=Math.max(max,dp1[i]);
            max=Math.max(max,dp2[i]);
        }
        return max;
    }
}


//RECURSION
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
         return nums[0];
        int potentialans1= find1(n-1 , nums, n);
        int potentialans2= find2(n-2, nums, n);
        return Math.max(potentialans1, potentialans2);
    }
    int find1(int i, int nums[], int n)
    {
        if(i<=0)
         return 0;
        
        return Math.max( find1(i-1,nums,n), find1(i-2, nums, n)+nums[i] );
    }
    int find2(int i, int nums[], int n)
    {
        if(i==0)
         return nums[0];

        if(i<0)
         return 0;
    
        return Math.max( find2(i-1,nums,n), find2(i-2, nums, n)+nums[i] );
    }
}


//MEMOIZATION
class Solution {
    int cache1[];
    int cache2[];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
         return nums[0];

        cache1=new int[n];
        cache2=new int[n];
        Arrays.fill(cache1,-1);
        Arrays.fill(cache2,-1);

        int potentialans1= find1(n-1 , nums, n);
        int potentialans2= find2(n-2, nums, n);
        return Math.max(potentialans1, potentialans2);
    }
    int find1(int i, int nums[], int n)
    {
        if(i<=0)
         return 0;
        
        if(cache1[i] != -1)
         return cache1[i];
        
        cache1[i]=Math.max( find1(i-1,nums,n), find1(i-2, nums, n)+nums[i] );
        return cache1[i];
    }
    int find2(int i, int nums[], int n)
    {
        if(i==0)
         return nums[0];
        if(i<0)
         return 0;
        if(cache2[i] != -1)
         return cache2[i];
    
        cache2[i]=Math.max( find2(i-1,nums,n), find2(i-2, nums, n)+nums[i] );
        return cache2[i];
    }
}
