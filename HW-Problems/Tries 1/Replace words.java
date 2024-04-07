class Solution {
    class TrieNode
    {
        TrieNode children[];
        boolean isEnd;
        String tillnow;
        TrieNode()
        {
            children=new TrieNode[26];
            isEnd=false;
            tillnow="";
        }
    }
    TrieNode root=new TrieNode();
    void insert(String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
             node.children[c-'a']=new TrieNode();
            
            String prev=node.tillnow;
            node=node.children[c-'a'];
            if(node.tillnow.length() == 0)
             node.tillnow=prev+c;
        }
        node.isEnd=true;
    }
    String check(String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null || node.isEnd)
             break;

            node=node.children[c-'a'];
        }
        if(node.isEnd)
         return node.tillnow;
        else
         return s;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String i:dictionary)
            insert(i);
            
        sentence+=" ";
        String ans="";
        String str[]=sentence.split(" ");
        for(String i:str)
         ans+=" "+check(i);
         
        return ans.trim();
    }
}