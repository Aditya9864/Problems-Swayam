class Solution {
    public int maxProduct(int[] nums) {
        int lpr=1,rpr=1;
        int pr=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            lpr=lpr*nums[i];
            rpr=rpr*nums[n-1-i];
            pr=Math.max(pr, Math.max(rpr,lpr));
            if(lpr==0)
             lpr=1;
            if(rpr==0)
             rpr=1;
        }
        return pr;
    }
}