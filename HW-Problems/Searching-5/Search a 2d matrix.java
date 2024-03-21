class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(matrix[mid][0]==target)
             return true;
            else if(matrix[mid][0]>target)
                high=mid-1;
            else
            {
                if(bins(matrix[mid],target) >= 0)
                  return true;
                else
                 low=mid+1;
            }
        }  
        return false;      
    }
    static int bins(int a[],int x)
    {
        int high=a.length-1;
        int low=0,mid=0;
        while(low<=high)
        {
            mid=(high+low)/2;
            if(a[mid]==x)
             return mid;
            else if(a[mid]>x)
             high=mid-1;
            else
            low=mid+1;
        }
        return -1;
    }
}