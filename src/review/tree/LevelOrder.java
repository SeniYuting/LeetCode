package review.tree;

import java.util.ArrayDeque;
import java.util.Queue;

// 二叉树的层次遍历
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode l31 = new TreeNode("G");
        TreeNode l23 = new TreeNode("F");
        TreeNode l22 = new TreeNode("E");
        TreeNode l21 = new TreeNode("D", l31, null);
        TreeNode l12 = new TreeNode("C", l23, null);
        TreeNode l11 = new TreeNode("B", l21, l22);
        TreeNode root = new TreeNode("A", l11, l12);

        StringBuilder sb = new StringBuilder();
        levelOrder(root, sb);
        System.out.println(sb.toString());
    }

    public static void levelOrder(TreeNode root, StringBuilder sb) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        //队列小知识：使用offer和poll优于add和remove之处在于它们返回值可以判断成功与否，而不抛出异常

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            sb.append(t.data).append(" ");
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
        }
    }
}
