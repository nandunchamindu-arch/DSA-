public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayCircularQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if (size == queue.length) {
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        return value;
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}