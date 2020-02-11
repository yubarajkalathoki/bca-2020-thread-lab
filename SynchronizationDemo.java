
public class SynchronizationDemo {
	static int c;
//TODO add synchronized keyword to make it consistant.
	static void increment() {
		for (int i = 0; i < 100; i++)
			c++;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				increment();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				increment();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Total count = " + c);

	}
}
