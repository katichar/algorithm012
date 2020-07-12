24. 两两交换链表中的节点
https://leetcode-cn.com/problems/swap-nodes-in-pairs/

时间复杂度 o(n)
空间复杂度 o(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}

学习目标 练习linkedlist中node指针交换值。