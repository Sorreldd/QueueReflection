package ru.artyomkomarov;

public class CircleQueue<E> implements Queue<E>{
	private class Node<E> {
		public E item;
	    public Node<E> next;
	}
	private Node<E> head = new Node<E>();
	
	private int kolElems = 0;
	@Override
	public void add(E element) {
		Node<E> lst = head;
		for(int i = 0; i < kolElems; i++) {
			lst = lst.next;
		}
		lst.next = new Node<E>();
		lst.next.item = element;
		lst.next.next = head;
		kolElems++;
	}

	@Override
	public E first() {
		if (kolElems == 0) throw new IndexOutOfBoundsException();
		return head.next.next.item;
	}

	@Override
	public boolean contains(E elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E poll() {
		if (kolElems == 0) throw new IndexOutOfBoundsException();
		
		return null;
	}

}
