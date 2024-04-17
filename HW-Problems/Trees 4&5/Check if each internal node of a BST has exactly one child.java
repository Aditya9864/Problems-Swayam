boolean onlyOneChild(int[] preorder) 
{
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    for(int i=1; i<preorder.length; i++) 
    {
        if (preorder[i] < min || preorder[i] > max)
            return false;

        if (preorder[i] < preorder[i - 1])
            max = preorder[i - 1];
        else
            min = preorder[i - 1];
    }
    return true;
}