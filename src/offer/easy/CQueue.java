package offer.easy;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/15 16:48
 * @Description:
 */
public class CQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(11);
        System.out.println(obj.deleteHead());
        obj.appendTail(1);
        obj.appendTail(17);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
