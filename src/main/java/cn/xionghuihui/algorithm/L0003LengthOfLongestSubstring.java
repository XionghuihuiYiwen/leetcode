package cn.xionghuihui.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 3. 无重复字符的最长子串 <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 * @author 灰灰
 * @since 2022-06-18 10:11:28
 *
 * 滑动窗口
 */
public class L0003LengthOfLongestSubstring {

    private static int t2(String source) {
        if (source.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < source.length(); i ++){
            if(map.containsKey(source.charAt(i))){
                left = Math.max(left, map.get(source.charAt(i)) + 1);
            }
            map.put(source.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    private static int t1(String source) {
        if (source == null) {
            return 0;
        }
        int result = 0;
        List<Character> characters = new ArrayList<>();
        for (char c : source.toCharArray()) {
            int index = characters.indexOf(c);
            if (index >= 0) {
                characters = characters.subList(index + 1, characters.size());
            }
            characters.add(c);
            System.out.println(index + "---" + characters);
            result = Math.max(result, characters.size());
        }

        return result;
    }
}
