public class ChronometerTest {

    public static void main(String[] args) {

        Chronometer chronometer = new Chronometer();

        Thread thread1 = new Thread(() -> {
            try {
                chronometer.printEverySecond();
            } catch (InterruptedException e) {
                System.out.println("Tread 1 has been interrupted");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                chronometer.printMessageEveryFiveSeconds();
            } catch (InterruptedException e) {
                System.out.println("Tread 2 has been interrupted");
            }
        });

        thread1.start();
        thread2.start();
    }
}