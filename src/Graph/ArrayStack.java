package Graph;

public class ArrayStack<T> {
    private T[] array;
    private int top;
    private int size;
    private int cap;

    @SuppressWarnings("unchecked")
    public ArrayStack(int cap) {
        this.array = (T[]) new Object[cap]; // Generic array creation
        this.top = -1;
        this.size = 0;
        this.cap = cap;
    }

    public void push(T data) {
        if (size == cap) {
            System.out.println("Stack is FULL! Cannot push!");
        } else {
            this.array[++top] = data;
            size++;
        }
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            throw new ArrayIndexOutOfBoundsException();
        } else {
            T value = this.array[top];
            array[top--] = null; // Avoid memory leak
            size--;
            return value;
        }
    }

    public T top() {
        if (this.top == -1) {
            System.out.println("Stack is Empty");
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return this.array[top];
        }
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            array[i] = null;
        }
        this.top = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void look() {
        for (int i = top; i >= 0; i--) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}