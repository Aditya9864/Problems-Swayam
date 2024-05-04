/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.Hashtable;
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
         return node;

        Hashtable< Node,Node > hash=new Hashtable<>();
        Queue<Node> q= new LinkedList<>();

        //Node first= new Node(node.val);
        q.add(node);
        hash.put(node,new Node(node.val,new ArrayList<>()));
        while(!q.isEmpty())
        {
            Node curr=q.poll();

            for(Node neigh: curr.neighbors)
            {
                if(!hash.containsKey(neigh))
                {
                    hash.put(neigh, new Node(neigh.val,new ArrayList<>()));
                    q.add(neigh);
                }
                Node toAddNeigh=hash.get(neigh);
                hash.get(curr).neighbors.add(toAddNeigh);
            }
        }
        return hash.get(node);
    }
}