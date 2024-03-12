class Solution
{
    public int NthRoot(int n, int m)
    {
        int ans=0;
        int low=1,high=m,mid=0;
        if(m==1)
         return 1;
        while(low<=high)
        {
            mid=(high+low)/2;
            if(Math.pow(mid,n)<=m)
            {
                ans=mid;
                low=mid+1;
            }
            else 
             high=mid-1;
        }
        if(Math.pow(ans,n)==m)
         return ans;
        else
         return -1;
    }
}