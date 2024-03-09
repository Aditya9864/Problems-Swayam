class Solution {
    public int mySqrt(int x) {
        int low =1, high=(Math.min(x,Integer.MAX_VALUE));
        int mid=0;
        if(x==0)
         return 0;
        while(low<=high)
        {
            mid=low+ (high-low)/2;
            if((long)mid*mid > (long)x)
             high=mid-1;
            else if( (long)mid*mid < (long)x )
             low=mid+1;
            else
             break;
        }
        if(mid*mid <= x)
         return mid;
        else
         return mid-1;
    }
}