import java.util.*;
class TrieNode
{
    TrieNode children[];
    boolean isEnd;
    List<String> names;
    TrieNode()
    {
        children= new TrieNode[26];
        isEnd=false;
        names=new ArrayList<String>();
    }
}
public class complete_using_trie {
    static TrieNode root= new TrieNode();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of words in dictionary:");
        int n=sc.nextInt();
        String dictionary[]=new String[n];
        System.out.println("Enter the words:");
        for(int i=0;i<n;i++)
          dictionary[i]=sc.next();

        for(String i:dictionary)
         insert(i);
        System.out.println("Enter the characters:");
        TrieNode node=root;
        String prefix="";
        while(true)
        {
            char c=sc.next().charAt(0);
            prefix=prefix+c;
            if(node.children[c-'a']==null)
            {
                System.out.println("No names with this prefix");
                break;
            }
            else
            {
                node=node.children[c-'a'];
                System.out.print("names with prefix "+prefix+":");
                System.out.println(node.names);
            }
        }
        sc.close();
    }
    static void insert(String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
            {
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
            node.names.add(s);
        }
        node.isEnd=true;
    }

}
