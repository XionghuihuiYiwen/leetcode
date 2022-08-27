package cn.xionghuihui.struct.stack;

/**
 * 灰灰 栈接口
 * 只研究数据结构 - 栈内元素不能为Null
 *
 * @author 灰灰
 * @since 2022-08-06 12:35:35
 */
public interface HStack<T> {

    /**
     * 入栈
     * @param item 元素
     */
    void push(T item);

    /**
     * 出栈
     * @return 出栈元素
     */
    T pop();

    /**
     * 是否为空
     * @return 是否为空
     */
    boolean isEmpty();
}
