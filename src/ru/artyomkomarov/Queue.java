package ru.artyomkomarov;

public interface Queue<E> {
	void add(E element); 
	E first();
	boolean contains(E elem); 
	E poll();   
}