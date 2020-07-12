时间复杂度 o(n)
空间复杂度 o(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next; //临时存下一个node
            curr.next = prev; //当前node 链接到prev
            prev = curr; //为下次循环准备 prev 变为 curr
            curr = temp; //curr 变为 temp
        }
        return prev;
    }
}
学习目标：linkedlist比较基础题目，反练习node指针交换值，类似交换两个变量值，需要借助第三个临时变量。
206. 反转链表
https://leetcode-cn.com/problems/reverse-linked-list/