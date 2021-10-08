package leetcodeTest.listNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest143 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr,n);
        reorderList(head);
        listNode.printLinkedList(head);
    }

    public static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        ListNode dummyNode = new ListNode(0);
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            list.get(left).next = list.get(right);
            left ++;
            if(left == right){
                break;
            }
            list.get(right).next = list.get(left);
            right --;
        }
        list.get(left).next = null;
    }

    public static void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        //mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
