class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        int low=mat[0][0];
        int high=mat[mat.length-1][mat[0].length-1];
        int ans=0 ;
        while(low<=high)
        {
            int mid =(high+low)/2;
            if(isSmaller(mat,mid)<k)
                low=mid+1;
            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    static int isSmaller(int mat[][], int mid){
        int i=0 ;
        int ans=0;
        int j=mat[0].length-1;
        while(i<mat.length && j>=0)
        {
            if(mat[i][j]>mid)
                j--;
            else
            {
                ans+=j+1;
                i++;
            }
        }
        return ans;
    }
}