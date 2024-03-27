public int findMedian(int[][] A) {
    int low=1;
	int high=Integer.MAX_VALUE;
	while(low<=high)
	{
	    int mid=(high+low)/2;
	    int k=0;
	    for(int i=0;i<n;i++)
		{
	      k=k+matrix(A[i],mid);
	    }
	    if(k<=(A.length*A[0].length)/2)
	      low=mid+1;
	    else
	      high=mid-1;
	}
	  return low;
}
static int matrix(int[] arr,int mid)
{
	int low=0;
	int high=arr.length-1;
	while(low<=high)
	{
	
	    int m=(low+high)/2;
	    if(arr[m]<=mid)
	        low=mid+1;
	    else
	        high=mid-1;
	}
	    return low;
}
