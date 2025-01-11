package LeetCode.Top150.DivideConquer;


public class SortList {
    static class Solution {
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
    }

    public static ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
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

    public static void main(String[] args) {
        SortList.Solution solution = new SortList.Solution();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode listNode = solution.sortList(node1);
        System.out.println(listNode);


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
}