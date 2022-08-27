package cn.xionghuihui.algorithm;


/**
 * 67. 二进制求和 <a href="https://leetcode.cn/problems/add-binary/">67. 二进制求和</a>
 * @author huihui.xiong
 * @since 2022-07-11 18:09:10
 */
public class L0067AddBinary {

    public static void main(String[] args) {
        L0067AddBinary l0067AddBinary = new L0067AddBinary();
        System.out.println(l0067AddBinary.addBinary("101", "1001"));
    }

    public String addBinary(String a, String b) {
        char[] chars01 = a.toCharArray();
        char[] chars02 = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int aPoint = chars01.length - 1;
        int bPoint = chars02.length - 1;
        boolean isOver = false;
        while (aPoint >= 0 || bPoint >= 0 || isOver) {
            int value1 = aPoint < 0 ? 0 : getValue(chars01[aPoint]);
            int value2 = bPoint < 0 ? 0 : getValue(chars02[bPoint]);

            int currentResult = value1 + value2;
            if (isOver){
                currentResult = currentResult + 1;
            }
            if (currentResult == 0 || currentResult == 1) {
                isOver = false;
            } else if (currentResult == 2) {
                currentResult = 0;
                isOver = true;
            } else if (currentResult == 3) {
                currentResult = 1;
                isOver = true;
            } else {
                throw new RuntimeException("计算错误");
            }
            result.insert(0, currentResult);
            aPoint--;
            bPoint--;
        }
        return result.toString();
    }

    private int getValue(char source) {
        switch (source) {
            case '1': return 1;
            case '0': return 0;
            default:
                throw new RuntimeException("值错误");
        }
    }
}
