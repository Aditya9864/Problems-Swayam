class Solution {
    class TrieNode
    {
        TrieNode children[];
        int count;
        TrieNode()
        {
            children=new TrieNode[26];
            count=0;
        }
    }
    TrieNode root=new TrieNode();

    void insert(String word)
    {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();
            
            node=node.children[c-'a'];
            node.count++;
        }
    }
    int countAtThisWord(String word)
    {
        TrieNode node=root;
        int score=0;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(node.children[c-'a']==null)
              break;

            node=node.children[c-'a'];
            score+=node.count;
        }
        return score;
    }

public int[] sumPrefixScores(String[] words) {
        int ans[]= new int[words.length];
        int k=0;

        for(String i:words)
         insert(i);

        for(String s:words)
         ans[k++]=countAtThisWord(s);

        return ans;
    }
}