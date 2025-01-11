package LeetCode.Top150.DivideConquer;


public class SortList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(4);
        node.add(2);
        node.add(1);
        node.add(3);

        ListNode listNode = solution.sortList(node);
        listNode.print();
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode tmp = mid.next;
        mid.next = null;

        ListNode left = head;
        ListNode right = tmp;
        left = this.sortList(left);
        right = this.sortList(right);
        return merge(left, right);
    }

    private ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }

        tail.next = (node1 != null) ? node1 : node2;

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int val) {
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    public void print() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}