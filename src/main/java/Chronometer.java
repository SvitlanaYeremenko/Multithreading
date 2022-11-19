public class Chronometer {
    private static final long START_TIME = System.currentTimeMillis();
    private long time;
    private final Object monitor = new Object();

    public void printEverySecond() throws InterruptedException {

        while (!Thread.interrupted()) {
            synchronized (monitor) {
                time = getElapsedTime();
                System.out.println("Elapsed time from start of the program: " + time + " seconds");
                monitor.wait(1000);
                monitor.notifyAll();
            }
        }
    }

    public void printMessageEveryFiveSeconds() throws InterruptedException {

        while (!Thread.interrupted()) {
            synchronized (monitor) {
                while (time % 5 == 0 && time != 0) {
                    System.out.println("5 seconds elapsed");
                    monitor.wait();
                }
            }
        }
    }

    private long getElapsedTime() {
        return  ((System.currentTimeMillis() - START_TIME) / 1000) % 60;
    }
}