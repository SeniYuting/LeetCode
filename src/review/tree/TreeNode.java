package review.tree;

public class TreeNode {

    public String data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(String data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
