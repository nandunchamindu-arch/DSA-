import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data) {
        s1.push(data);
    }

    public int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int dequeued = s1.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return dequeued;
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}