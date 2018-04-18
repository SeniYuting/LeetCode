package review.tree;

public class BinaryTreeSerializeAndDeserialize {

    static int index = 0;

    static TreeNode deserialize(String s) {
        String[] strings = s.split(",");
        return beginDeserialize(strings);
    }

    static TreeNode beginDeserialize(String[] strings) {
        if (index >= strings.length) {
            throw new IllegalArgumentException();
        }

        if (strings[index].equals("$")) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.data = strings[index];
        index++;
        node.left = beginDeserialize(strings);
        index++;
        node.right = beginDeserialize(strings);

        return node;
    }

    static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        beginSerialize(root, sb);
        return sb.toString();
    }

    // 前序遍历
    static void beginSerialize(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("$,");
            return;
        }

        sb.append(node.data + ",");
        beginSerialize(node.left, sb);
        beginSerialize(node.right, sb);
    }

    public static void main(String[] args) {
        String s = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        TreeNode root = BinaryTreeSerializeAndDeserialize.deserialize(s);
        System.out.println(BinaryTreeSerializeAndDeserialize.serialize(root));
    }
}
