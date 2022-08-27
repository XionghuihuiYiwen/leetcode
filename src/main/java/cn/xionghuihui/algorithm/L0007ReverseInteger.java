package cn.xionghuihui.algorithm;

/**
 * 整数反转
 * 7. 整数反转 <a herf="https://leetcode.cn/problems/reverse-integer/">整数反转</a>
 * @author 灰灰
 * @since 2022-07-10 22:04:30
 */
public class L0007ReverseInteger {

    private int reverse03(int x) {
        int maxResult = Integer.MAX_VALUE / 10;
        int minResult = Integer.MIN_VALUE / 10;
        int result = 0;
        while (x != 0) {
            if (result > maxResult || result < minResult) {
                return 0;
            }
            int tmp = x % 10;
            x = x /10;
            result = result * 10 + tmp;
        }
        return result;
    }


    /**
     * 首尾交换
     */
    private int reverse02(int x) {
        String xString = String.valueOf(x);
        boolean isLessThenZero = x < 0;
        if (isLessThenZero) {
            xString = xString.substring(1);
        }

        char[] chars = xString.toCharArray();
        // 如果长度为1 不需要做交换了，直接返回即可
        if (chars.length == 1) {
            return x;
        }

        int start = 0, end = chars.length -1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start ++;
            end--;
        }

        StringBuilder appender = new StringBuilder();
        boolean isStart = false;
        for (char aChar : chars) {
            if (isStart) {
                appender.append(aChar);
                continue;
            }
            if (aChar != '0') {
                isStart = true;
                appender.append(aChar);
            }
        }

        String reverseString = appender.toString();
        if ( "".equals(reverseString)) {
            reverseString = "0";
        }
        reverseString = isLessThenZero?  "-" + reverseString : reverseString;
        long l = Long.parseLong(reverseString);

        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.parseInt(reverseString);
    }

    /**
     * 逆序输出
     */
    private int reverse01(int x) {
        String xString = String.valueOf(x);
        boolean isLessThenZero = x < 0;
        if (isLessThenZero) {
            xString = xString.substring(1);
        }

        StringBuilder appender = new StringBuilder();
        boolean start = false;
        char[] chars = xString.toCharArray();
        for (int i = chars.length -1 ; i >= 0; i--) {
            char current = chars[i];
            if ('0' == current) {
                if (start) {
                    appender.append(current);
                }
                continue;
            }
            if (!start) {
                start = true;
            }
            appender.append(current);
        }
        String reverseString = appender.toString();
        if ( "".equals(reverseString)) {
            reverseString = "0";
        }
        reverseString = isLessThenZero?  "-" + reverseString : reverseString;
        long l = Long.parseLong(reverseString);

        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.parseInt(reverseString);
    }


}
