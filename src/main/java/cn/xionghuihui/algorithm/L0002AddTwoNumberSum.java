package cn.xionghuihui.algorithm;

/**
 * 两数相加 <a href="https://leetcode.cn/problems/add-two-numbers/">两数相加</a>
 *
 * @author 灰灰
 * @since 2022-06-18 08:56:27
 */
public class L0002AddTwoNumberSum {

    /**
     * 目前这种解法的思路是每一位进行相加，在循环的同时构建出结果的链表
     */
    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // tmp1和tmp2 是参数的链表的两个指针，在循环过程中指向当前的数据
            ListNode tmp1 = l1, tmp2 = l2;
            // isOver 则表示上一次的结果是否发生了进位
            boolean isOver = false;
            // 结果链表的头节点
            ListNode resultHead = null;
            // 结果链表的当前指针
            ListNode tmpNode = null;
            while (tmp1 != null || tmp2 != null || isOver) {
                // 获取当前循环的两个链表的值，空则取0
                int tmp1val = tmp1 == null ? 0 : tmp1.val;
                int tmp2val = tmp2 == null ? 0 : tmp2.val;
                // 计算当次循环的取值
                int tmp = isOver ? tmp1val + tmp2val + 1 : tmp1val + tmp2val;
                // 是否进位
                isOver = tmp > 9;
                // 获取当前链表的计算结果，这里取余极客
                tmp = tmp % 10;
                ListNode innerTmpNode = new ListNode(tmp);
                // 将 链表元素 放入结果链表中
                if (resultHead == null) {
                    resultHead = innerTmpNode;
                    tmpNode = innerTmpNode;
                } else {
                    tmpNode.next = innerTmpNode;
                    tmpNode = tmpNode.next;
                }
                // 参数指针移位
                tmp1 = tmp1 == null ? null : tmp1.next;
                tmp2 = tmp2 == null ? null : tmp2.next;
            }
            return resultHead;
        }

        public ListNode reserve(ListNode source) {

            if (source.next == null) {
                return new ListNode(source.val);
            }

            ListNode result = new ListNode(source.val);
            ListNode tmp = source.next;
            while (tmp != null) {
                result = new ListNode(tmp.val, result);
                tmp = tmp.next;
            }
            return result;
        }
    }

    private static void testReserve() {
        Solution solution = new Solution();
        ListNode head = new ListNode(10);
        ListNode testNode = head;
        for (int i = 1; i < 10; i++) {
            ListNode next = new ListNode(10 - i);
            testNode.next = next;
            testNode = next;
        }

        ListNode printHead = head;
        do {
            System.out.println(printHead.val);
            printHead = printHead.next;
        } while (printHead != null);
        System.out.println("------");

        printHead = solution.reserve(head);
        do {
            System.out.println(printHead.val);
            printHead = printHead.next;
        } while (printHead != null);
    }

    private static class ListNode {
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

}
