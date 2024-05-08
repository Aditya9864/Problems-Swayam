//RECURSION
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        return find(nums, n-1);
    }
    int find(int nums[], int n)
    {
        if(n<0)
         return 0;

        return Math.max( find(nums,n-1), find(nums, n-2)+ nums[n]);
    }
}


//MEMOIZATION
class Solution {
    int cache[];
    public int rob(int[] nums) {
        int n=nums.length;
        cache=new int[n+1];
        Arrays.fill(cache,-1);
        return find(nums, n-1);
    }
    int find(int nums[], int i) 
    {
        if(i<0)
          return 0;
        if(cache[i] >= 0)
            return cache[i];
            
        int loot=Math.max( find(nums,i-1), find(nums, i-2)+nums[i] );
        cache[i]=loot;
        return loot;
    }
}

//BOTTOM-UP
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


//BOTTOM-UP OPTIMIZED
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
         return nums[0];
         
        int a= nums[0];
        int b= Math.max(nums[0],nums[1]);
        int c= 0;
        for(int i=2;i<n;i++)
        {
            c=Math.max(b, a+nums[i]);
            a=b;
            b=c;
        }
        return b;
    }
}
