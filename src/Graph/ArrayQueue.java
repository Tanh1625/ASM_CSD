package Graph;



public class ArrayQueue<T> {

    T data[];
    int front, back, size;
    int cap;

    public ArrayQueue(int cap) {
        this.cap = cap;
        this.data = (T[]) new Object[cap];
        this.back = -1;
        this.front = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return this.size == this.cap;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void clear(){
        this.data = (T[]) new Object[cap];
        this.back = -1;
        this.front = -1;
        this.size = 0;
    }

    public void enQueue(T data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (this.front == -1) {
            this.front = 0;
            this.back = 0;
            this.data[0] = data;
            this.size++;
            return;
        }
        if (this.size == 0) {
            this.front = (this.front + 1) % this.cap;
        }
        this.back = (this.back + 1) % this.cap;
        this.data[this.back] = data;
        this.size++;
    }
    public T deQueue(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        if(this.size == 1){
            T value = this.data[this.front];
            this.clear();
            return value;
        }
        T value = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front+1) % this.cap;
        this.size--;
        return value;
    }
    public void traverse(){
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[(this.front+i) % this.cap] + " ");
        }
        System.out.println("");
    }
}
