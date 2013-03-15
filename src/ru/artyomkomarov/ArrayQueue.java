package ru.artyomkomarov;



public class ArrayQueue<E> implements Queue<E> {
	private E[] elems = (E[])new Object[4];
	private int n = 4, kolElems = 0, endOfQ = 0, headOfQ = 0;
	
	@Override
	public void add(E element) {
		if(n == kolElems + 1) {
			int indx = 0;
			E[] tmpe = (E[])new Object[2 * n];
			while(headOfQ != endOfQ) {
				tmpe[indx] = elems[headOfQ];
				headOfQ = (headOfQ + 1) % n;
				indx++;
			}
			n *= 2;
			headOfQ = 0;
			endOfQ = indx;
			elems = tmpe;
		}
		elems[endOfQ] = element;
		endOfQ = (endOfQ + 1) % n;
		kolElems++;
	}

	@Override
	public E first() {
		if (kolElems == 0) throw new IndexOutOfBoundsException();
		return elems[headOfQ];
	}

	@Override
	public boolean contains(E elem) {
		int head = headOfQ, end = endOfQ;
		while(head != end) {
			if(elem == elems[head]) return true;
			head = (head + 1) % n;
		}
		return false;
	}

	@Override
	public E poll() {
		if (kolElems == 0) throw new IndexOutOfBoundsException();
		int head = headOfQ; 
		headOfQ = (headOfQ + 1) % n;
		kolElems--;
		return elems[head];
	}

}
