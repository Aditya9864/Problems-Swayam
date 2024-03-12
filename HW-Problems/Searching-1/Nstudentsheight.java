import java.util.*;
public class Nstuheight {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int Q=sc.nextInt(),i=0;
        int a[]=new int[N];
        for(i=0;i<N;i++)
         a[i]=sc.nextInt();
        Arrays.sort(a);
        int x[]=new int[Q];
        for(i=0;i<Q;i++)
         x[i]=sc.nextInt();
        i=0;
        while(Q>0)
        {
            System.out.println(bins(a,x[i],N));
            Q--; i++;
        }
        sc.close();
    }
    static int bins(int a[],int t, int n)
    {
        int low=0,high=n-1;
        int ans=0;
        while(low<=high)
        {
            int mid=(high+low)/2;
            if(a[mid]==t)
            {
                return n-mid;
            }
            else if(a[mid]>t)
             high=mid-1;
            else
            {
             low=mid+1;
             ans=n-mid-1;
            }
        }
        return ans;
    }
}
