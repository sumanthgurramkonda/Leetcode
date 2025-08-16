/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder tree = new StringBuilder();
    public String serialize(TreeNode root) {
        dfs(root);
        return tree.toString();
    }

    public void dfs(TreeNode root){
        if(root==null){
            tree.append("NULL,");
            return;
        }
        tree.append(root.val+",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return decode(data.split(","));
    }
    int index = 0;
    public TreeNode decode(String[] tree){
        if("NULL".equals(tree[index])) return null;
        TreeNode node = new TreeNode(Integer.parseInt(tree[index]));
        index+=1;
        TreeNode left = decode(tree);
        index+=1;
        TreeNode right = decode(tree);
        node.left = left;
        node.right = right;
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));