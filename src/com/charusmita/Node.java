package com.charusmita;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;

    public Node(T data){
        setData(data);
        setNext(null);
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> nodeData){
        this.next = nodeData;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

}
