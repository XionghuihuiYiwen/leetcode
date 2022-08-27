package cn.xionghuihui.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/design-skiplist/">1206. 设计跳表</a>
 * @author 灰灰
 * @since 2022-08-06 21:10:48
 */
public class L1206SkipList {

    public static void main(String[] args) {
        L1206SkipList te = new L1206SkipList();
        te.test1();
    }

    private void test1() {
    }

    class Skiplist {

        final int maxLevel = 5;

        Random random = new Random();

        SkipNode head = new SkipNode(-1, maxLevel); //头节点

        int level = 1; // 当前的层级，默认有一层

        class SkipNode {
            int val;
            SkipNode[] forwards;

            public SkipNode(int val, int level) {
                this.val = val;
                forwards = new SkipNode[level];
            }
        }

        public boolean search(int target) {
            SkipNode current = head;
            for (int i = level -1; i >= 0; i--) {
                while (current.forwards[i] != null && (current.forwards[i].val < target)) {
                    current = current.forwards[i];
                }
            }
            return current.forwards[0] != null && current.forwards[0].val == target;
        }

        public boolean erase(int num) {
            // 记录跳表中每一个层级的前序位置
            SkipNode[] levelPres = new SkipNode[maxLevel];
            SkipNode current = head;
            for (int i = level -1; i >= 0; i--) {
                while (current.forwards[i] != null && (current.forwards[i].val < num)) {
                    current = current.forwards[i];
                }
                levelPres[i] = current;
            }
            SkipNode removeData = levelPres[0].forwards[0];
            if (removeData == null || removeData.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (levelPres[i].forwards[i] != removeData) {
                    break;
                }
                levelPres[i].forwards[i] = removeData.forwards[i];
            }
            // 更新当前的 level
            while (level > 1 && head.forwards[level - 1] == null) {
                level--;
            }
            return true;
        }

        public void add(int num) {
            // 记录跳表中每一个层级的前序位置
            SkipNode[] levelPres = new SkipNode[maxLevel];
            Arrays.fill(levelPres, head);

            SkipNode current = head;
            // 当前使用的层级 i 遍历每一层
            for (int i = level -1 ; i >= 0 ; i--) {
                // 遍历当前层级小于传入数据中最大的一个元素，即当前层级可以插入的位置的后面
                while (current.forwards[i] !=null && current.forwards[i].val < num) {
                    current = current.forwards[i];
                }
                levelPres[i] = current;
            }

            // 当前数据需要落到第几层
            int lv = randomLv();
            // 当前最大的层级数需要更新一下
            level = Math.max(lv, level);

            SkipNode newNode = new SkipNode(num, lv);
            for (int i = 0; i < lv; i++) {
                newNode.forwards[i] = levelPres[i].forwards[i];
                levelPres[i].forwards[i] = newNode;
            }
        }

        private int randomLv() {
          return random.nextInt(maxLevel) + 1;
        }

    }
}
