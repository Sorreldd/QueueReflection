package ru.artyomkomarov;

public interface Queue<E> {
	void add(E element); // добавляет элемент в очередь
	E first(); // возвращает головной элемент очереди, не удаляя его
	boolean contains(E elem); // проверяет, содержится ли элемент в очереди
	E poll(); // возвращает головной элемент очереди, удаляя его
}