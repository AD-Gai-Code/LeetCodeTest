package leetcodeTest.listNode;

public class LeetCodeTest147 {
    public static void main(String[] args) {
        int[] arr = {1,1};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr,n);
        head = insertionSortList(head);
        listNode.printLinkedList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode lastSorted = head;
        ListNode needInsert = head.next;
        while(needInsert != null){
            if(lastSorted.val <= needInsert.val){
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummyNode;
                while(pre.next.val <= needInsert.val){
                    pre = pre.next;
                }
                lastSorted.next = needInsert.next;
                needInsert.next = pre.next;
                pre.next = needInsert;
            }
            needInsert = lastSorted.next;
        }
        return dummyNode.next;
    }
}
