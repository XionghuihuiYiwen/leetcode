package cn.xionghuihui.algorithm;

/**
 * 4.寻找两个正序数组的中位数 <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">寻找两个正序数组的中位数</a>
 * @author huihui.xiong
 * @since 2022-06-22 18:07:45
 */
public class L0004FindMedianSortedArrays {

    private static final L0004FindMedianSortedArrays INSTANCE = new L0004FindMedianSortedArrays();

    public static L0004FindMedianSortedArrays getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        double medianSortedArrays = INSTANCE.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = mergeSort(nums1, nums2);
        int length = ints.length;
        int middle = length / 2;
        if ((length % 2) == 0 ) {
            return (double)(ints[middle] + ints[middle-1]) / 2;
        } else {
            return (double)ints[middle];
        }
    }

    /**
     * 这里假设 nums1和nums2 都是有序的
     */
    private int[] mergeSort(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2;
        }

        if (nums2 == null) {
            return nums1;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] merge = new int[length1 + length2];
        int mergeIndex = 0;
        int x = 0;
        int y = 0;
        while (x < length1 || y < length2) {
            if ( x < length1 && y < length2) {
                int temp1 = nums1[x];
                int temp2 = nums2[y];
                if (temp1 >= temp2) {
                    merge[mergeIndex] = temp2;
                    mergeIndex ++;
                    y ++;
                    continue;
                } else {
                    merge[mergeIndex] = temp1;
                    mergeIndex ++;
                    x ++;
                    continue;
                }

            }
            if (x < length1 && y == length2) {
                int temp1 = nums1[x];
                merge[mergeIndex] = temp1;
                mergeIndex ++;
                x++;
                continue;
            }
            if (x == length1 && y < length2) {
                int temp2 = nums2[y];
                merge[mergeIndex] = temp2;
                mergeIndex ++;
                y++;
                continue;
            }
        }
        return merge;
    }
}
