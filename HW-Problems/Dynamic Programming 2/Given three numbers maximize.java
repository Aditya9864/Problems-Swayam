import java.util.*;
class solution{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter x y z:");
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        System.out.println("Enter length of array:");
	    int n=sc.nextInt();
	    int a[]=new int[n];
	    System.out.println("Enter elements:");
	    for(int i=0 ; i<n; i++)
            a[i]=sc.nextInt();

        int lmax=Integer.MIN_VALUE;
        int rmax=Integer.MIN_VALUE;
        lmax=x*a[0];
        rmax=z*a[n-1]; 
        for(int i= n-2; i>=0; i--) 
            rmax = Math.max(rmax, z*a[i]); 
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
        {
            ans=Math.max(ans, lmax+ y*a[i] + rmax);
            lmax=Math.max(lmax, x*a[i]);
            //rmax=Math.max(rmax, z*a[i]);
        }
        System.out.println("Answer:"+ans);
        sc.close();
    }
}
 
 