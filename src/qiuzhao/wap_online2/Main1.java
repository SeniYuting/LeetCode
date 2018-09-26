package qiuzhao.wap_online2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1. 判断两棵树是否相等
 * 2. 判断是否为对称树
 * 3. 反转树
 */
public class Main1 {

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String val) {
            this.val = val;
        }

        TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode getTree1() {
        System.out.println("      A");
        System.out.println("     / \\");
        System.out.println("    B   C");
        System.out.println("   / \\ / \\");
        System.out.println("  D  E F  G");
        System.out.println(" / \\");
        System.out.println("H  I");

        TreeNode l32 = new TreeNode("I");
        TreeNode l31 = new TreeNode("H");
        TreeNode l24 = new TreeNode("G");
        TreeNode l23 = new TreeNode("F");
        TreeNode l22 = new TreeNode("E");
        TreeNode l21 = new TreeNode("D", l31, l32);
        TreeNode l12 = new TreeNode("C", l23, l24);
        TreeNode l11 = new TreeNode("B", l21, l22);
        TreeNode lroot = new TreeNode("A", l11, l12);

        return lroot;
    }

    static TreeNode getTree2() {
        System.out.println("      A");
        System.out.println("     / \\");
        System.out.println("    B   B");
        System.out.println("   / \\ / \\");
        System.out.println("  D  E E  D");

        TreeNode s22 = new TreeNode("E");
        TreeNode s21 = new TreeNode("D");
        TreeNode s12 = new TreeNode("B", s22, s21);
        TreeNode s11 = new TreeNode("B", s21, s22);
        TreeNode sroot = new TreeNode("A", s11, s12);

        return sroot;
    }

    public static void main(String[] args) {
        TreeNode t1 = getTree1();
        TreeNode t2 = getTree2();
        System.out.println();

        System.out.println("isSame： " + isSame(t1, t1));
        System.out.println("isSame： " + isSame(t1, t2));
        System.out.println("isSymmetric1： " + isSymmetric1(t1));
        System.out.println("isSymmetric1： " + isSymmetric2(t1));
        System.out.println("isSymmetric1： " + isSymmetric1(t2));
        System.out.println("isSymmetric1： " + isSymmetric2(t2));

        TreeNode invert = invertTree(t1);
        System.out.println(levelOrder(invert, true));
    }

    static boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val.equals(root2.val)) {
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        } else {
            return false;
        }
    }

    // 是否对称 -- 递归
    static boolean isSymmetric1(TreeNode node) {
        if (node == null)
            return true;
        return isSymmetric(node.left, node.right);

    }

    static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val.equals(root2.val)) {
            return isSymmetric(root1.left, root2.right) && isSymmetric(root2.left, root1.right);
        } else {
            return false;
        }
    }

    // 是否对称 -- 非递归
    static boolean isSymmetric2(TreeNode node) {
        return levelOrder(node, true).equals(levelOrder(node, false));
    }

    static String levelOrder(TreeNode root, boolean leftToright) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            sb.append(t.val).append(" ");

            if (leftToright) {
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            } else {
                if (t.right != null) {
                    queue.offer(t.right);
                }
                if (t.left != null) {
                    queue.offer(t.left);
                }
            }
        }
        return sb.toString();
    }

    // 反转树 -- 递归
    static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }
}
