class Solution {
    public boolean search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<=high)
        {
           int mid=(low+high)/2;
            if(nums[mid]==target)
             return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high])
            {
                low=low+1;
                high=high-1;
            }
            else
            {
              if(nums[mid]>=nums[low]) //mid in right part
              {
                  if(nums[low]<=target) // target in right part
                    {
                      if(nums[mid]<target)
                       low=mid+1;
                      else
                       high=mid-1;
                    }
                  else  // target in left part
                    low=mid+1;
              }
              else  // mid in left part
              {
                  if( nums[high] >= target ) //target in right part
                  {
                      if(nums[mid] < target)
                       low=mid+1;
                      else
                       high=mid-1;
                  }
                  else // target in left part
                      high=mid-1;
              }
            }
        }
        return false;
    }
}