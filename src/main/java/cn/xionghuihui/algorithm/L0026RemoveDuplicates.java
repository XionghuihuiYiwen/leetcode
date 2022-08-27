package cn.xionghuihui.algorithm;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 * @author 灰灰
 * @since 2022-08-07 13:06:53
 */
public class L0026RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left ++;
                nums[left] = nums[right];
                right ++;
            } else {
                right ++;
            }
        }
        return left + 1;
    }


    public int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left =0, right = 1;
        int preVal = nums[left];
        int maxLength = nums.length;
        while (right < maxLength) {
            int num = nums[right];
            if (preVal == num) {
                right ++;
                continue;
            }
            int moveLength = right - left -1;
            if (moveLength == 0) {
                left ++;
                right ++;
                preVal = nums[left];
                continue;
            }
            maxLength -= moveLength;
            for (int i = left + 1; i < maxLength; i++) {
                nums[i] = nums[i + moveLength];
            }
            left ++;
            right = left + 1;
            preVal = nums[left];
        }
        maxLength = maxLength - (right - left -1);
        return maxLength;
    }
}
