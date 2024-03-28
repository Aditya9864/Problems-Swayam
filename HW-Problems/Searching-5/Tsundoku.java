import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int M=sc.nextInt();
    long K=sc.nextLong();
    int a[]=new int[N+1];
    int b[]= new int[M+1];
    long psa[]=new long[N+1];
    long psb[]= new long[M+1];
    psa[0]=0;
    psb[0]=0;
    for(int i=1;i<=N;i++)
    {
      a[i]=sc.nextInt();
      psa[i]=psa[i-1]+a[i];
    }
    for(int i=1;i<=M;i++)
    {
      b[i]=sc.nextInt();
      psb[i]=psb[i-1]+b[i];
    }
    long max = 0;
    for(int i = 0; i <= N; i++)
    {
        long diff = K - psa[i], ans = 0;
        if(diff < 0)
            break;
        int low = 1, high = M;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(psb[mid] <= diff)
            {
                ans = mid;
                low = mid + 1; 
            }
            else
                high = mid - 1;
        }
        max = Math.max(max, i+ans);  
    }
    System.out.println(max);
    sc.close();
  }
}