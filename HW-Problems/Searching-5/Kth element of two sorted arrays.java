import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        if(m<n)
         return kthElement(arr2,arr1,m,n,k);
        int low=Math.max(0,k-m);
        int high=Math.min(k,n);
        int l1,l2,r1,r2;
        while(low<=high)
        {
            int mid1=(high+low)/2;
            int mid2=k-mid1;
            l1=(m1==0)?Integer.MIN_VALUE:arr1.get(mid1-1);
            r1=(m1==n)?Integer.MAX_VALUE:arr1.get(mid1);
            l2=(m2==0)?Integer.MIN_VALUE:arr2.get(mid2-1);
            r2=(m2==m)?Integer.MAX_VALUE:arr2.get(mid2);
            if(l1<=r2 && l2<=r1)
             return Math.max(l1,l2);
            else if(l1>r2)
             high=mid1-1;
            else if(l2>r1)
             low=mid1+1;
        }
        return 0;
    }
}