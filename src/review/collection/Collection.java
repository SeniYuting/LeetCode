package review.collection;

import java.util.*;

public class Collection {

    public static void main(String[] args) {

        // HashMap遍历
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "一");
        map.put(3, "三");
        map.put(2, "二");
        // 法一
        for (Map.Entry<Integer, String> m : map.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
        // 法二
        for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry m = (Map.Entry) it.next();
            System.out.println(m.getKey() + ":" + m.getValue());
        }

        // ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove((Integer) 1);  // remove：参数Object类型

        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Hashtable
        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(5, "五");
        ht.put(7, "七");
        ht.put(6, "六");

        // iterator遍历
        for (Iterator it = ht.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry m = (Map.Entry) it.next();
            System.out.println(m.getKey() + ":" + m.getValue());
        }

        // enumeration遍历
        Enumeration<Integer> eht = ht.keys();
        while (eht.hasMoreElements()) {
            Integer i = eht.nextElement();
            System.out.println(i + ":" + ht.get(i));
        }

        int i = 1;
        i = i++;
        System.out.println(i);

        // 数组产生list
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> a.compareTo(b)); // Lambda 表达式
        for (String n : names) {
            System.out.print(n + " ");
        }
        System.out.println();

        // HashMap，基于Node<K,V>[] table，表格的每一个元素是Node<K,V>链表
        // putVal
        // 待插入值hash后与表格中已有值都不匹配，则在表格中新加一个Node<K,V>元素
        // 否则比较与表格中的值是否相等
        // 1. 若相等，则替换表格中的值
        // 2. 若不相等
        // 2.1 若待插入值是TreeNode类型，则调用putTreeVal()方法处理
        // 2.2 依次遍历链表后的节点
        // 2.2.1 若遍历的点为链表的尾节点，则插入新值
        // 2.2.1.1 若超过链表的长度，则将链表扩展为红黑树
        // 2.2.2 若遍历的点与待插入值相等，则更新遍历的点
        // 2.2.3 否则，向后遍历

    }
}
