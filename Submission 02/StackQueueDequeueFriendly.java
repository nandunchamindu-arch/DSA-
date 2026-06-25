import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return s1.pop();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}