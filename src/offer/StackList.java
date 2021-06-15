package offer;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/15 16:48
 * @Description:
 */
public class StackList {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
//        stack1.clear();
//        stack2.push(node);
//        Stack<Integer> tmp = new Stack<Integer>();
//        tmp.addAll(stack2);
//        while (!tmp.isEmpty()) {
//            stack1.push(tmp.pop());
//        }
        stack1.push(node);
    }

    public int pop() {
//        Stack<Integer> tmp = new Stack<Integer>();
//        tmp.addAll(stack1);
//        tmp.pop();
//        stack2.clear();
//        while (!tmp.isEmpty()) {
//            stack2.push(tmp.pop());
//        }
//        return stack1.pop();
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackList newStack = new StackList();
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        newStack.push(4);
        System.out.println(newStack.pop());
        newStack.push(5);
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
    }
}
