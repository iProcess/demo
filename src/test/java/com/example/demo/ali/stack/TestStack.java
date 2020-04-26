package com.example.demo.ali.stack;

import java.util.Stack;

/**
 * https://blog.csdn.net/weixin_40739833/article/details/80554996
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        // 元素入栈
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        try {
            // 栈空时会抛出 EmptyStackException 异常进入catch块，从而结束打印
            while(stack.peek() != null) {
                // 出栈栈顶元素，并打印出栈元素
                System.out.println(stack.pop());
            }
        } catch(Exception e) {
            System.out.println("栈空");
        }
    }
}
