package leetcodeTest.listNode;

public class LeetCodeTest82 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr,n);
        head = deleteDuplicates(head);
        listNode.printLinkedList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
                // 如果没有 else 运行情况是怎么样的？
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
