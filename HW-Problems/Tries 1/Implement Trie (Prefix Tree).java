class Trie {
    TrieNode root;
    class TrieNode
    {
        TrieNode children[];
        boolean isEnd;
        TrieNode()
        {
            children= new TrieNode[26];
            isEnd=false;
        }
    }
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(node.children[c-'a']==null)
            {
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(node.children[c-'a']==null)
            {
                return false;
            }
            node=node.children[c-'a'];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            if(node.children[c-'a']==null)
            {
                return false;
            }
            node=node.children[c-'a'];
        }
        return true;
    }
}
