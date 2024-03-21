import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<boards.size();i++)
        {
            low=Math.max(s,boards.get(i));
            high=high+boards.get(i);
        }
        while(low<high)
        {
            int mid=(high+low)/2;
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
        for(int i=0;i<boards.size();i++)
        {
            low=low+boards.get(i);
            if(low>mid){
                low=boards.get(i);
                k--;
            }
            if(k==0)
             return false;
        }
        return true;
    }
}
