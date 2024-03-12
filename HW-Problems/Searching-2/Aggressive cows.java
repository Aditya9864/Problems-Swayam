class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low=0,high=stalls[stalls.length-1]-stalls[0]+1;
        int ans=1,mid=0;
        while(low<=high)
        {
            mid=(high+low)/2;
            if(canPlace(stalls,stalls.length,k,mid) == true)
            {
                ans=mid;
                low=mid+1;
            }
            else
             high=mid-1;
        }
        return ans;
    }
    static boolean canPlace(int stalls[],int numstalls,int numcows,int dist)
    {
        int lastplacedcow=stalls[0];
        int totalcowsplaced=1;
        for(int i=0;i<numstalls;i++)
        {
            if(stalls[i]-lastplacedcow >= dist)
            {
             totalcowsplaced++;
             lastplacedcow=stalls[i];
            }
        }
        return (totalcowsplaced >= numcows);
    }
}