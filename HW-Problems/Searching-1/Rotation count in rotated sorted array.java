static int rotation(int a[],int n)
    {
        int low=0,high=n-1;
        if(n<=1)
         return 0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid==0 && a[mid]<a[mid+1])
              return mid;
            if(mid==n-2 && a[mid]>a[mid+1])
              return mid+1;
            if(mid!=0 && a[mid]<a[mid-1] && a[mid]<a[mid+1])
             return mid;
            else if(a[mid]<a[low])
             high=mid-1;
            else
             low=mid+1;
        }
        return 0;
    }