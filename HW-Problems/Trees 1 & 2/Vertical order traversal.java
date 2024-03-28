/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tri
{
    int row;
    int column;
    TreeNode node;
    Tri(int row,int column,TreeNode node)
    {
        this.row=row;
        this.column=column;
        this.node=node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tri> q=new LinkedList<Tri>();
        List<List<Integer>> ans= new ArrayList<>();  
        q.offer(new Tri(0,0,root));
        while(!q.isEmpty())
        {
            Tri t=q.poll();
            int x=t.row;
            int y=t.column;
            TreeNode n=t.node;

            map.putIfAbsent(x,new TreeMap<>());

            map.get(x).putIfAbsent(y,new PriorityQueue<>());

            map.get(x).get(y).offer(n.val);

            if(n.left != null)
             q.offer(new Tri(x-1,y+1,n.left));
            if(n.right != null)
             q.offer(new Tri(x+1,y+1,n.right));
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> x: map.values())
        {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> y: x.values())
            {
                while(!y.isEmpty()){
                    ans.get(ans.size()-1).add(y.poll());
                }
            }
        }
        return ans;
    }
}