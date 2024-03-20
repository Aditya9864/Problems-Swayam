class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k > bloomDay.length) 
         return -1;
        int ans=-1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; i++) 
        {
            high = Math.max(bloomDay[i], high);
            low = Math.min(bloomDay[i],low) ;
        }
        while(low<=high)
        {
            int mid = (low + high) / 2;
            if(canMake(bloomDay, m, k, mid)) 
            {
                ans=mid;
                high=mid-1;
            }
            else 
                low=mid+1;
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay, int m, int k , int mid){
         int count=0,fcount=0;
         for (int i = 0; i < bloomDay.length; i++) 
         {
            if(bloomDay[i] <= mid) 
            {
                count++;
                if (count == k) 
                {
                    fcount++;
                    count=0;
                }
            } 
            else 
              count = 0;
         }
         if(fcount>=m)
          return true;
         else
          return false;
    }
}