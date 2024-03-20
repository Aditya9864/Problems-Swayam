class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int low=0,high=s.length();
        int[] a=new int[high];
        int ans=0;
        for(int i=0;i<s.length();i++)
         a[i]=Math.abs(s.charAt(i)-t.charAt(i));
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(canChange(a,mid,maxCost))
            {
                ans=mid;
                low=mid+1;
            }
            else
             high=mid-1;
        }
        return ans;
    }
    public boolean canChange(int[] a,int mid,int max)
    {
        int i=0,j=0,temp=0;
        while(j<a.length)
        {
         temp=temp+a[j];
         while(temp>max)
         {
            temp=temp-a[i];
            i++;
         }
         if((j-i+1)>=mid)
          return true;
         j++;
        }
        return false;
    }
}