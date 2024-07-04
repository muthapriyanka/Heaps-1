//time complexity:O(nlogk)
//space complexity:O(k)
import java.util.*;

public class FindLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        FindLargest s= new FindLargest();
        int[] nums = new int[] { 1, 3, 2, 5, 6, 4 };
        System.out.println(s.findKthLargest(nums, 2));

    }
}
