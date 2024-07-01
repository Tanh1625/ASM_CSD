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


import java.util.EmptyStackException;

import java.util.EmptyStackException;

/**
 *
 * @author ACER
 */
public class ArrayStack <T>{
    T arr[];
    int size;
    int top;
    int cap;

    public ArrayStack( int cap) {
       
        this.cap = cap;
        this.arr = (T[])new Object[cap];
        this.top = -1;
        this.size = 0;
    }
    public boolean isFull(){
        return this.size == cap;
    }
    public boolean isEmpty(){
        return this.size == -1;
    }
    public void look(){
        for (int i = 0; i < this.size; i++) {
            System.out.println(arr[top-i] + " ");
        }
    }
    public void push(T data){
        if(isFull()){
            throw new ArrayStoreException("Stack is full,cannot push ");
        }
        this.top++;
        this.arr[top] = data;
        this.size++;
    }
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T data = arr[top];
        this.arr[top] = null;
        this.top--;
        this.size--;
        return data;
        }
    
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[top];
    }
    public void clear(){
        this.arr = (T[])new Object[cap];
        this.top = -1;
        this.size = 0;
    }
}

