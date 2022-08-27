package cn.xionghuihui.algorithm;

/**
 * 删除最外层括号
 * <a src="https://leetcode.cn/problems/remove-outermost-parentheses">删除最外层括号</a>
 *
 * @author 灰灰
 * @since 2022-08-06 13:42:49
 */
public class L1021RemoveOuterParentheses {

    public static void main(String[] args) {
        L1021RemoveOuterParentheses in = new L1021RemoveOuterParentheses();
        System.out.println(in.removeOuterParentheses("(()())(())"));
    }

    public String removeOuterParenthesesWithStack(String s) {
        // TODO 实现栈结构没完成本题目 cn.xionghuihui.struct.stack.HStack

        return null;
    }

    public String removeOuterParentheses(String s) {
        final char LEFT = '(';
        final char RIGHT = ')';

        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();

        int lPoint =0, rPoint = 0;
        int count = 0;
        boolean start =false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == LEFT) {
                start = true;
                if (count == 0) {
                    lPoint = i;
                }
                count ++;
            } else if (c == RIGHT) {
                if (count > 0) {
                    rPoint = i;
                }
                count --;
            }
            if (start && count == 0) {
                result.append(s, lPoint + 1, rPoint);
            }
        }

        return result.toString();
    }

}
