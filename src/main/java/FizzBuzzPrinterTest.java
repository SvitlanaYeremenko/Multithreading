public class FizzBuzzPrinterTest {
    public static void main(String[] args) {

        FizzBuzzPrinter printer = new FizzBuzzPrinter(15);

        Thread a = new Thread(() -> {
            try {
                printer.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try {
                printer.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread c = new Thread(() -> {
            try {
                printer.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread d = new Thread(() -> {

            try {
                printer.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
        c.start();
        d.start();
    }
}
