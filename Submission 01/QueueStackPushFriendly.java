import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int data) {
        q1.add(data);
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}