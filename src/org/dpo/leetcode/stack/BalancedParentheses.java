package org.dpo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static void main(String[] args) {
        String s = "((())";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        //()
        Deque<Character> stack = new ArrayDeque<>();
        var sArr = s.toCharArray();
        for (char ch : sArr) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                var top = stack.pop();
                if (top == '(' && ch != ')') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
