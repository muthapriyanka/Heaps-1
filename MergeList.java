import java.util.PriorityQueue;

//Definition for singly-linked list.
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

public class MergeList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }

    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeList m = new MergeList();

        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[] { 1, 4, 5 });
        lists[1] = createList(new int[] { 1, 3, 4 });
        lists[2] = createList(new int[] { 2, 6 });

        ListNode mergedList = m.mergeKLists(lists);

        // Print merged list
        ListNode curr = mergedList;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
