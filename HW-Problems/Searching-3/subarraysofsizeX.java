import java.util.Arrays;
public class subarraysofsizeX {
    public static void main(String[] args) {
        int a[]={1,3,4,2};
        Arrays.sort(a);
        int s=7;
        System.out.println(findx(a,s));
    }
    static int findx(int a[],int s)
    {
        int low=1,high=a.length;
        int ans=0;
        while(low<=high)
        {
            int mid=(high+low)/2;
            if( isSumofSubarrsLess(a,s,mid) )
            {
                ans=mid;
                low=mid+1;
            }
            else
             high=mid-1;
        }
        return ans;
    }
    static boolean isSumofSubarrsLess(int a[],int s,int mid)
    {
        int sum=0;
        for(int i=a.length-mid;i<a.length;i++)
        {
            sum=sum+a[i];
        }
        if(sum<=s)
         return true;
        return false;
    }
}
