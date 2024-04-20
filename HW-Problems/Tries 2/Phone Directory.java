class Solution{
    static class TrieNode
    {
        TrieNode children[];
        ArrayList<String> common;
        TrieNode()
        {
            children=new TrieNode[26];
            common=new ArrayList<>();
        }
    }
    static TrieNode root= new TrieNode();
    static void insert(String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();
            
            node=node.children[c-'a'];
            node.common.add(s);
        }
    }
    static ArrayList<String> query(String s)
    {
        TrieNode node=root;
        ArrayList<String> com=new ArrayList<String>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
              return new ArrayList<String>();
            
            node=node.children[c-'a'];
        }
        com.addAll(node.common);
        return com;
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        Arrays.sort(contact);
        for(String i:contact)
         insert(i);
         
        ArrayList<ArrayList<String>> result= new ArrayList<ArrayList<String>>();
        String str="";int k=0;
        for(int i=0;i<s.length();i++)
        {
            str=str+s.charAt(i);
            ArrayList<String> temp=query(str);
            if(temp.size()!=0)
            {
                if(k==0)
                 result.add(temp);
                else if(temp.equals(result.get(i-1)))
                 result.add(result.get(i-1));
                else if(!temp.equals(result.get(i-1)))
                 result.add(temp);
            }
            else
            {
                temp.add("0");
                result.add(temp);
            }
        }
        return result;
    }
}