/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author ACER
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ACER
 */
public class ArrayQueue<T> {
    T array[];
    int size;
    int cap;
    int front,back;

    public ArrayQueue( int cap) {
        this.cap = cap ;
        this.array = (T[]) new Object[cap];
        this.size = 0;
        this.front = -1;
        this.back = -1;
        
    }
    public boolean isFull(){
        return this.size == this.cap;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void clear (){
        this.array = (T[]) new Object[cap];
        this.size = 0;
        this.front = -1;
        this.back = -1;
    }
    public void enQueue(T data){
        if(this.isFull()){
            System.out.println("QUEUE IS FULL");
            return;
        }if(this.isEmpty()){
            this.front = this.back = 0;
            this.array[this.back] = data;
            this.size++;
            return;
        }
        this.back = (this.back +1) % this.cap;
        this.array[this.back] = data;
        this.size++;
    }
    public T deQueue(){
        if(this.isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return null;
        }if(this.size == 1){
            T value = this.array[this.front];
            this.clear();
            return value;
        }
        T value = this.array[this.front];
        this.array[this.front] = null;
        this.front = (this.front +1)%this.cap;
        this.size--;
        return value;
    }
    public T front(){
        if(this.isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return null;
        }
        T value = this.array[this.front];
        return value;
    }
    public void traverse(){
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[(this.front+i)%this.cap] + " ");
        }
    }
}
