package com.example.demo.ali.stack;

import java.util.Stack;

public class Valid {

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true; //空串为真
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(' || t == '[' || t == '{') { //左括号入栈
                stack.push(t);
            } else {
                if(stack.empty()){
                    return false;
                }
                char t1 = stack.pop();
                if (t1 == '(' && t == ')'){
                    continue;
                }else if (t1 == '[' && t == ']'){
                    continue;
                }else if (t1 == '{' && t == '}'){
                    continue;
                }else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
