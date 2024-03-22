package ch03;

import java.util.Stack;

public class IterativeExploration {
    static void displayPatternIterative(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        while(!stack.isEmpty()) {
            int current = stack.pop();
        }
    }
}
