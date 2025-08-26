package org.dpo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static void main(String[] args) {
        String s = "(())";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if(c== '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if( c == ')' && top != '(') {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}
