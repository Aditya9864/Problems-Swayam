import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<boards.length;i++)
        {
            low=Math.max(s,boards[i]);
            high=high+boards[i];
        }
        while(low<high)
        {
            int mid=(hig+low)/2;
            if(canPaint(boards,mid,k))
             high=mid;
            else
             low=mid+1;
        }
        return high;
    }
    public static boolean canPaint(ArrayList<Integer> boards,int mid,int k)
    {
        int low=0;
        for(int i=0;i<boards.length;i++)
        {
            low=low+boards[i];
            if(low>mid){
                low=boards[i];
                k--;
            }
            if(k==0)
             return false;
        }
        return true;
    }
}