package cn.xionghuihui.algorithm;

/**
 * 141. 环形链表:<a href="https://leetcode.cn/problems/linked-list-cycle/">...</a>
 * @author 灰灰
 * @since 2022-08-06 20:14:37
 */
public class L0141HasCycle {

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public boolean hasCycle(ListNode head) {
          if (head == null || head.next == null) {
              return false;
          }
        ListNode node1 = head.next;
        ListNode node2 = head;
        while (node1!=null && node1.next!= null && node2!=null) {
            if (node1 == node2) {
                return true;
            }
            node1 = node1.next.next;
            node2 = node2.next;
        }
        return false;
    }
}
