class Solution {
    class TrieNode
    {
        TrieNode children[];
        int index;
        String word;
        TrieNode()
        {
            children=new TrieNode[26];
            index=-1;
            word="";
        }
    }
    TrieNode root=new TrieNode();
    void insert(int ind,String s)
    {
        TrieNode node=root;
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();

            node=node.children[c-'a'];
            if(node.word=="" || node.word.length() > s.length())
            {
                node.word=s;
                node.index=ind;
            }
        }
        return;
    }
    int query(String s,int def)
    {
        TrieNode node=root;
        int ind=def;
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(node.children[c-'a'] != null)
            {
                node=node.children[c-'a'];
                ind=node.index;
            }
            else
             return ind;
        }
        return ind;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int ans[]=new int[wordsQuery.length];
        for(int i=0; i<wordsContainer.length; i++)
            insert(i, wordsContainer[i]);

        int def=0,len=wordsContainer[0].length();
        for(int i=0;i<wordsContainer.length;i++)
        {
            if(wordsContainer[i].length()<len)
            {
             def=i;
             len=wordsContainer[i].length();
            }
        }

        for(int i=0;i<wordsQuery.length;i++)
            ans[i]=query(wordsQuery[i],def);

        return ans;
    }
}