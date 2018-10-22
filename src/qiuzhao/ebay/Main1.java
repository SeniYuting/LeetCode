package qiuzhao.ebay;

// input:
// 7 5
// 100 400 300 100 500 101 400

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        String[] stones = sc.nextLine().split(" ");

        Node head = merge(transfer(stones), n, m);

        long max = 0;
        while (head != null) {
            max = Math.max(max, head.value);
            head = head.next;
        }
        System.out.println(max);
    }

    private static Node transfer(String[] stones) {
        Node head = new Node(Integer.parseInt(stones[0]));

        Node temp = head;
        for (int i = 1; i < stones.length; i++) {
            temp.next = new Node(Integer.parseInt(stones[i]));
            temp = temp.next;
        }

        return head;
    }

    private static Node merge(Node head, int n, int m) {
        Node temp;

        for (int i = 0; i < n - m; i++) {
            temp = head;
            Node minNode = null;
            long minSum = Long.MAX_VALUE;

            while (temp.next != null) {
                long sum = temp.value + temp.next.value;
                if (sum < minSum) {
                    minNode = temp;
                    minSum = sum;
                }
                temp = temp.next;
            }

            if (minNode != null) {
                minNode.value = minSum;
                minNode.next = minNode.next.next;
            }
        }

        return head;
    }
}

class Node {
    long value;
    Node next;

    Node(long v) {
        value = v;
        next = null;
    }
}
