package leetcodeTest.listNode;

public class LeetCodeTest23 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] arr1 = {};
        int[] arr2 = {-1, 5, 11};
        int[] arr3 = {};
        int[] arr4 = {6,10};
        ListNode list1 = listNode.createLinkedList(arr1, 0);
        ListNode list2 = listNode.createLinkedList(arr2, 3);
        ListNode list3 = listNode.createLinkedList(arr3, 0);
        ListNode list4 = listNode.createLinkedList(arr4, 2);
        ListNode[] lists = {list1, list2, list3,list4};
        ListNode head = mergeKLists(lists);
        listNode.printLinkedList(head);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPrt = b;
        while (aPtr != null && bPrt != null) {
            if (aPtr.val < bPrt.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPrt;
                bPrt = bPrt.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPrt);
        return head.next;
    }

    /*public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }*/
}
