package leetcodeTest.listNode;

public class LeetCodeTest61 {
    public static void main(String[] args) {
        int[] arr = {0};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr, n);
        head = rotateRight(head, 4);
        listNode.printLinkedList(head);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = head;
        ListNode slow = dummyNode;

        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len ++;
            temp = temp.next;
        }
        int n = k % len;
        if(n == 0){
            return head;
        }
        for (int i = 0; i < k  - 1; i++) {
            if (fast.next == null && i < k ) {
                fast = head;
                continue;
            } else {
                fast = fast.next;
            }
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        dummyNode.next = cur;
        fast.next = head;
        slow.next = null;
        return dummyNode.next;
    }
}
