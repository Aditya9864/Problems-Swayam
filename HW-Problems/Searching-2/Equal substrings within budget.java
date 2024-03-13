class Solution {
    public int equalSubstring(String s, String t, int maxCost) {  //Still figuring out BS solution
        int maxwindow=0;                                          // here's the sliding window one
        int n=s.length();
        int i=0,j=0;
        int ans=0;
        for(j=0;j<n;j++)
        {
            int temp=Math.abs(s.charAt(j)-t.charAt(j));
            maxwindow = maxwindow + temp;
            if(maxwindow > maxCost)
            {
                while(maxwindow>maxCost)
                {
                    maxwindow-=Math.abs(s.charAt(i)-t.charAt(i));
                    i++;
                }
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}