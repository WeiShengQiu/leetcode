package offer.easy;

import java.util.Stack;

public class MinStack {
    Stack<Integer> nor = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        nor.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else {
            min.push(Math.min(min.peek(), node));
        }
    }

    public void pop() {
        nor.pop();
        min.pop();
    }

    public int top() {
        return nor.peek();
    }

    public int min() {
        return min.peek();
    }
}
