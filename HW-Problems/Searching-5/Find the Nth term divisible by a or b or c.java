import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int n=sc.nextInt();
        int low=0,high=Integer.MAX_VALUE;
        int ans=0;
        while(low<=high)
        {
            int mid=(high+low)/2;
            int count=mid/a+mid/b+mid/c-mid/lcm(a,b)-mid/lcm(b,c)-mid/lcm(c,a)+mid/lcm(a,h);
            if(count == n)
            {
                ans=mid;
                high=mid-1;
            }
            else if(count<n)
                low=mid+1;
            else
                high=mid-1;
        }
        System.out.println(ans);
    }
    public static int gcd(int a,int b)
    {
     if (a==0)
        return b;
     return gcd(b%a,a);
    }
    public static int lcm(int a,int b)
    {
     return (a/gcd(a,b))*b;
    }
}