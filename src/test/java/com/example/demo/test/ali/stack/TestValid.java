package com.example.demo.test.ali.stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 譬如："()[]{}"为合法，"(]"、"([)]"均为非法。
 *
 * 思路：栈，遇到左括号入栈，非左括号出栈并检查是否匹配，如果不匹配则非法。如果整个字符串遍历完了且栈也为空，则合法。
 * ————————————————
 * 版权声明：本文为CSDN博主「FlyingApe」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_35190319/java/article/details/86518120
 */
public class TestValid {

    public static void main(String[] args) {
        System.out.println(new Valid().isValid("()[]{}"));
        System.out.println(new Valid().isValid("(]"));
        System.out.println(new Valid().isValid("([)]"));
        System.out.println(new Valid().isValid("})]"));
    }
}
