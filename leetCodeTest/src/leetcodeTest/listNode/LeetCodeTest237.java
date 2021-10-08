package leetcodeTest.listNode;

public class LeetCodeTest237 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,9};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr,n);
        ListNode cur = head;
        while (cur.val != 1){
            cur = cur.next;
        }
        deleteNode(cur);
        listNode.printLinkedList(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
