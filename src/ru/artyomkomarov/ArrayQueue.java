package ru.artyomkomarov;



public class ArrayQueue<E> implements Queue<E> {
	private E[] elems = (E[])new Object[4]; // заводим нашу очередь, в начале расчитана на 4 элемент
	private int n = 4, kolElems = 0, endOfQ = 0, headOfQ = 0; 
	/* 
	 * n - количество элементов способных пометиться в нашу очередь
	 * kolElems - количество элементов в очереди в данный момент времени
	 * endOfQ - указатель на конец очереди
	 * headOfQ - указатель на голову очереди
	 */
	
	@Override
	public void add(E element) {
		if(n == kolElems + 1) { // если элементы будут не помещаться, очередь расширится в два раза
			int indx = 0; 
			E[] tmpe = (E[])new Object[2 * n]; // создаем новую очередь в два раза больше прежней
			while(headOfQ != endOfQ) { // переводим элементы из старой очереди в новую
				tmpe[indx] = elems[headOfQ];
				headOfQ = (headOfQ + 1) % n;
				indx++;
			}
			n *= 2; // говорим что теперь очередь расчитана на в два раза большее количество элементов 
			headOfQ = 0; // кидаем указатель на голову
			endOfQ = indx; // кидаем указатель на хвост
			elems = tmpe; // переприсваем нашу очередь
		}
		elems[endOfQ] = element; // добавляем элемент в очередь
		endOfQ = (endOfQ + 1) % n; // сдвигаем хвост
		kolElems++; // увеличиваем счетчик количества элементов
	}

	@Override
	public E first() {
		if (kolElems == 0) throw new IndexOutOfBoundsException(); // если очередь пуста, кидаем Exception
		return elems[headOfQ]; // возвращаем головной элемент
	}

	@Override
	public boolean contains(E elem) {
		int head = headOfQ, end = endOfQ;
		while(head != end) { // проходим по очереди и ищем элемент, который был передан
			if(elem == elems[head]) return true; // true если нашли
			head = (head + 1) % n;
		}
		return false; // false элемент в очереди не найден
	}

	@Override
	public E poll() { 
		if (kolElems == 0) throw new IndexOutOfBoundsException(); // проверяем очередь на пустоту, если пуста -> Exception
		int head = headOfQ; // запоминаем головной элемент
		headOfQ = (headOfQ + 1) % n; // сдвигаем голову очереди
		kolElems--; // счетчик количества элементов в очереди уменьшаем
		return elems[head]; // возвращаем головной элемент, указатель на который мы запомнили
	}

}
