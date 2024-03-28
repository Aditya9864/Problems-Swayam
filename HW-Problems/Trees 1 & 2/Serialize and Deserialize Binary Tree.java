public class Codec {
    String X ="*";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if (root == null)
            return X;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    String[] arr;
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        return serial();
    }
    public TreeNode serial() 
    {
        if (arr[index].equals(X)) 
        {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        root.left = serial();
        root.right = serial();
        return root;
    }
}