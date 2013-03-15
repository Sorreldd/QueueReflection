package ru.artyomkomarov;

public class CircleQueue<E> implements Queue<E>{
	private class Node<E> { // Список
		public E item; // элемент 
	    public Node<E> next; // указатель на следующий Node
	}
	private Node<E> head = new Node<E>(); // Создадим голову списка
	
	private int kolElems = 0;
	@Override
	public void add(E element) {
		Node<E> lst = head;
		for(int i = 0; i < kolElems; i++) { // Сдвигаемся к концу списка
			lst = lst.next;
		}
		lst.next = new Node<E>(); // Добавляем новый элемент в конец списка
		lst.next.item = element;
		lst.next.next = head; // Кидаем ссылку от последнего в голову
		kolElems++; // Увеличиваем счетчик элементов в очереди
	}

	@Override
	public E first() {
		if (kolElems == 0) throw new IndexOutOfBoundsException(); // если очередь пуста, кидаем Exception
		return head.next.item; // возвращаем головной элемент
	}

	@Override
	public boolean contains(E elem) {
		Node<E> lst = head;
		for(int i = 0; i < kolElems; i++) { // пробегаем по списку
			lst = lst.next;
			if(lst.item == elem) return true; // true если находим элемент, который нам задан
		}
		return false; // false если нужный элемент в очереди не содержится
	}

	@Override
	public E poll() {
		if (kolElems == 0) throw new IndexOutOfBoundsException(); // если очередь пуста, кидаем Exception
		E element = head.next.item; // запоминаем головной элемент
		head.next = head.next.next; // сдвигаю голову очереди на следующий элемент
		kolElems--; // уменьшаем счетчик количества элементов
		return element; // возвращаем элемент, который запомнили
	}

}
