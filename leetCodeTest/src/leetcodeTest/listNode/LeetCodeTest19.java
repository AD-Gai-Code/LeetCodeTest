package leetcodeTest.listNode;

public class LeetCodeTest19 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr,n);
        head = removeNthFromEnd(head,7);
        listNode.printLinkedList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = head;
        ListNode slow = dummyNode;
        for(int i = 0; i < n; i ++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
