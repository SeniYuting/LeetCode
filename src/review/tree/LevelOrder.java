package review.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// 二叉树的层次遍历和之字形遍历
public class LevelOrder {

    public static void print() {
        System.out.println("      A");
        System.out.println("     / \\");
        System.out.println("    B   C");
        System.out.println("   / \\ / \\");
        System.out.println("  D  E F  G");
        System.out.println(" / \\");
        System.out.println("H  I");
    }

    public static void main(String[] args) {
        TreeNode l32 = new TreeNode("I");
        TreeNode l31 = new TreeNode("H");
        TreeNode l24 = new TreeNode("G");
        TreeNode l23 = new TreeNode("F");
        TreeNode l22 = new TreeNode("E");
        TreeNode l21 = new TreeNode("D", l31, l32);
        TreeNode l12 = new TreeNode("C", l23, l24);
        TreeNode l11 = new TreeNode("B", l21, l22);
        TreeNode root = new TreeNode("A", l11, l12);

        print();

        StringBuilder sb1 = new StringBuilder();
        levelOrder(root, sb1);
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        rotateOrder(root, sb2);
        System.out.println(sb2.toString());
    }

    /**
     * 层次遍历
     */
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

    /**
     * 之字形遍历
     * <p>
     * 使用两个辅助栈来分别存储奇数层节点和偶数层节点
     * 奇数层，从右往左插入，先添加右子树，再添加左子树
     * 偶数层，从左往右插入，先添加左子树，再添加右子树
     */
    public static void rotateOrder(TreeNode root, StringBuilder sb) {
        int level = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();

        while (!s1.empty() || !s2.empty()) {

            if (level % 2 != 0) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        sb.append(node.data).append(" ");
                        s2.push(node.right);
                        s2.push(node.left);
                    }
                }
            } else {
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        sb.append(node.data).append(" ");
                        s1.push(node.left);
                        s1.push(node.right);
                    }
                }
            }
            level++;
        }
    }
}
