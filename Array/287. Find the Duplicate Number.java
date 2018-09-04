// t:n s:1
/*
 * regard the array as a linked list
 * index <-> node.val, nums[index] <-> node.next
 * duplicate => two node have same next
 * => the linked list must contains a cycle
 * entrance of the cycle is duplicate num
 */
class Solution {
    public int findDuplicate(int[] nums) {
        // head = 0, because value between [1, n]
        int slow = 0; // slow = head
        int fast = 0; // fast = head
        do {
            slow = nums[slow]; // slow = slow.next
            fast = nums[nums[fast]]; // fast = fast.next.next
        } while (slow!=fast);
        int encounter = 0; // encounter = head
        while (encounter!=slow) {
            slow = nums[slow]; // slow = slow.next
            encounter = nums[encounter]; // encounter = encounter.next
        }
        return encounter;
    }
}