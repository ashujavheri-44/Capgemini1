
public class SyncDemo implements Runnable {

	@Override
	public void run() {
		display(Thread.currentThread().getName());
	}

	private void display(String name) {
		System.out.println(name + " has entered...");

		try {
			synchronized (this) {
				System.out.print("[");
				Thread.sleep(1000);
				System.out.print(name);
				Thread.sleep(1000);
				System.out.println("]");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SyncDemo sd = new SyncDemo();
		Thread t1 = new Thread(sd, "First");
		Thread t2 = new Thread(sd, "Second");
		Thread t3 = new Thread(sd, "Third");

		t1.start();
		t2.start();
		t3.start();
	}
}
