package review.tree;

import java.util.Stack;

// 二叉树的前序遍历：递归 & 非递归
public class PreOrder {
    public static void main(String[] args) {
        TreeNode l31 = new TreeNode("G");
        TreeNode l23 = new TreeNode("F");
        TreeNode l22 = new TreeNode("E");
        TreeNode l21 = new TreeNode("D", l31, null);
        TreeNode l12 = new TreeNode("C", l23, null);
        TreeNode l11 = new TreeNode("B", l21, l22);
        TreeNode root = new TreeNode("A", l11, l12);

        StringBuilder sb1 = new StringBuilder();
        preOrder1(root, sb1);
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        preOrder2(root, sb2);
        System.out.println(sb2.toString());
    }

    // 递归
    public static void preOrder1(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.data).append(" ");
            preOrder1(root.left, sb);
            preOrder1(root.right, sb);
        }
    }

    // 非递归：基于栈
    public static void preOrder2(TreeNode root, StringBuilder sb) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                sb.append(root.data).append(" ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }
}
