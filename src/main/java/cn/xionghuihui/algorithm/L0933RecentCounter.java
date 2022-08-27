package cn.xionghuihui.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 933. 最近的请求次数 <a href="https://leetcode.cn/problems/number-of-recent-calls/">...</a>
 * @author 灰灰
 * @since 2022-08-06 14:34:34
 */
public class L0933RecentCounter {

    public static class RecentCounter {

        Queue<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            queue.add(t);
            int left = t - 3000;
            Integer next = queue.peek();
            while (next !=null && next < left) {
                queue.poll();
                next = queue.peek();
            }
            return queue.size();
        }
    }


}
