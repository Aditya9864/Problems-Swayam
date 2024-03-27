class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        if(len2<len1)
         return findMedianSortedArrays(nums2,nums1);
        int low=0,high=len1;
        while(low<=high)
        {
            int mid1=(low+high)/2;
            int mid2=(len1+len2+1)/2-mid1;
            int l1=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            int r1=(mid1==len1)?Integer.MAX_VALUE:nums1[mid1];
            int l2=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            int r2=(mid2==len2)?Integer.MAX_VALUE:nums2[mid2];
            if(l1<=r2 && l2<=r1)
            {
                if((len1+len2)%2==0)
                 return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                return Math.max(l1,l2);
            }
            else if(l1>r2)
             high=mid1-1;
            else if(l2>r1)
             low=mid1+1;
        }
        return 0;
    }
}