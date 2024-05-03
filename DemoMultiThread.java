
public class DemoMultiThread {
    public static void main(String[] args) {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                Singleton singleton = Singleton.getInstance("BAR.");
                System.out.println("Thread 1");
                System.out.println(singleton.value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance(".BAR");
            System.out.println("Thread 2");
            System.out.println(singleton.value);
        }
    }
}