package ru.artyomkomarov;

public class QueueFactory<E> {

	private Class<Queue<E>> queueClass;

	public QueueFactory(String className) {
		try {
			queueClass = (Class<Queue<E>>)Class.forName("ru.artyomkomarov." + className);
		} catch (ClassNotFoundException ex) {
			queueClass = null;
		}
	}

	public QueueFactory(Class<Queue<E>> stackClass) {
		this.queueClass = stackClass;
	}
	public Queue<E> create() {
		try {
			return queueClass.newInstance();
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
		queue.add("FFS");
		queue.add("S");
		System.out.println(queue.first());
		//System.out.println(queue.poll());
		
		
	}
}