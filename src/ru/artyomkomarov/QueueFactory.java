package ru.artyomkomarov;


public class QueueFactory<E> {

	private Class<Queue<E>> queueClass;
	/* 
	 * Фабрика, будет штамповать нам экземпляры определенного класса
	 */
	public QueueFactory(String className) {
		try {
			queueClass = (Class<Queue<E>>)Class.forName("ru.artyomkomarov." + className); // Загружаем класс по названию
		} catch (ClassNotFoundException ex) {
			queueClass = null;
		}
	}

	public QueueFactory(Class<Queue<E>> queueClass) {
		this.queueClass = queueClass;
	}
	public Queue<E> create() {
		try {
			return queueClass.newInstance(); // Создаем экземпляр загруженного класса
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		String className = "CircleQueue";
		if (args.length > 0) {
			className = args[0];
		}
		QueueFactory<String> factory = new QueueFactory<String>(className); 
		Queue<String> queue = factory.create();
		
		long startTime = System.currentTimeMillis(); // Начальное время
		
		for(int i = 0; i < 10000; i++) {
			queue.add("Hello");
		}
		for(int i = 0; i < 10000; i++) {
			queue.contains("He");
		}
		for(int i = 0; i < 10000; i++) {
			queue.poll();
		}
		
		long endTime = System.currentTimeMillis(); // Конечное время
		System.out.println(endTime - startTime + " миллисекунд");
		
	}
}