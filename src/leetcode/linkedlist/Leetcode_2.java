package leetcode.linkedlist;

/**
 * 两数相加
 * 标签：链表
 * @author l00365373
 * @since 2020-06-11
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Leetcode_2 {
    // ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    //     if (l1 == NULL)
    //         return l2;
    //     else if (l2 == NULL)
    //         return l1;
    //
    //     int lengthA = 0, lengthB = 0;
    //     ListNode *pA = l1, *pB = l2;
    //     while (pA != NULL) {
    //         ++lengthA;
    //         pA = pA->next;
    //     }
    //     while (pB != NULL) {
    //         ++lengthB;
    //         pB = pB->next;
    //     }
    //
    //     ListNode *newHead = l1, *p = l1;
    //     if (lengthA < lengthB) {
    //         newHead = l2;
    //         p = l2;
    //     }
    //
    //     int carry = 0;  //进位
    //     pA = l1;
    //     pB = l2;
    //     while (pA != NULL && pB != NULL) {
    //         int temp = pA->val + pB->val + carry;
    //         p->val = temp % 10;
    //         carry = temp / 10;
    //
    //         pA = pA->next;
    //         pB = pB->next;
    //         p = p->next;
    //     }
    //     while (pA) {
    //         int temp = pA->val + carry;
    //         p->val = temp % 10;
    //         carry = temp / 10;
    //
    //         pA = pA->next;
    //         p = p->next;
    //     }
    //     while (pB) {
    //         int temp = pB->val + carry;
    //         p->val = temp % 10;
    //         carry = temp / 10;
    //
    //         pB = pB->next;
    //         p = p->next;
    //     }
    //     if (carry != 0) {
    //         p = newHead;
    //         while (p->next != NULL)
    //             p = p->next;
    //         ListNode *node = new ListNode(carry);
    //         p->next = node;
    //     }
    //
    //     return newHead;
    // }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
