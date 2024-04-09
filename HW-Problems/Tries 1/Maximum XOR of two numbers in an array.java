class Solution {
    class TrieNode
    {
        TrieNode children[];
        TrieNode()
        {
            children= new TrieNode[2];
        }
    }
    TrieNode root=new TrieNode();
    void insert(int n)
    {
        TrieNode node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(n>>i)&1;
            if(node.children[bit]==null)
                node.children[bit]=new TrieNode();
                
            node=node.children[bit];
        }
    }
    int query(int n)
    {
        TrieNode node=root;
        int XOR=0;
        for(int i=31;i>=0;i--)
        {
            int bit=(n>>i)&1;
            if(node.children[1-bit] ==null)
                node=node.children[bit];
            else
            {
             node=node.children[1-bit];
             XOR=XOR+(1<<i);
            }
        }
        return XOR;
    }
    public int findMaximumXOR(int[] nums) {
        int ans=0;
        int currXOR=0;
        insert(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            currXOR=query(nums[i]);
            ans=Math.max(ans,currXOR);
            insert(nums[i]);
        }
        return ans;
    }
}