class Solution {
    class TrieNode {
        int count;
        TrieNode children[];
        TrieNode()
        {
            count=0;
            children= new TrieNode[2];
        }
    }
    TrieNode root = new TrieNode();
    void insert(int n) 
    {
        TrieNode node=root;
        for (int i = 31; i >= 0; i--) 
        {
            int ind; 
            if((n & 1<<i) > 0) 
             ind=1;
            else 
             ind=0;
            if (node.children[ind]== null) 
                node.children[ind] = new TrieNode();

            node = node.children[ind];
            node.count++;
        }
    }
    int calculate(int n, int l) {
        TrieNode node = root;
        int res = 0;
        for (int i=31;i>=0; i--) 
        {
            int num = ((n & 1<<i) > 0) ? 1 : 0;
            int target = (num+1)%2;
            int lim = ((l & 1<<i) > 0) ? 1 : 0;
            if (lim == 1) 
            {
                if (node.children[target] == null) 
                    return res;
                node = node.children[target];
            } 
            else 
            {
                if (node.children[target] != null) 
                    res += node.children[target].count;
                if (node.children[num] == null) 
                    return res;
            
                node=node.children[num];
            }
        }
        return res;
    }
    public int countPairs(int[] nums, int low, int high) {
        int res=0;
        for (int n : nums) 
        {
            res+=(calculate(n, low-1)-calculate(n, high));
            insert(n);
        }
        return res;
    }
}