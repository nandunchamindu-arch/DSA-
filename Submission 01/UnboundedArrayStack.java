public class UnboundedArrayStack {

    private int[] stack;
    private int top;

    public UnboundedArrayStack() {
        stack = new int[2];
        top = -1;
    }

    public void push(int data) {
        if (top == stack.length - 1) {
            resize(stack.length * 2);
        }

        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int value = stack[top--];

        if (top + 1 > 0 && top + 1 <= stack.length / 4) {
            resize(stack.length / 2);
        }

        return value;
    }

    private void resize(int newSize) {
        int[] temp = new int[newSize];

        for (int i = 0; i <= top; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}