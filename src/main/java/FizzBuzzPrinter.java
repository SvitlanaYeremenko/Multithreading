public class FizzBuzzPrinter {

    private final int n;
    private int position = 1;

    public FizzBuzzPrinter(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {

        while (position <= n) {
            if (position % 3 == 0 && position % 5 != 0) {
                if (position == n) {
                    System.out.print("fizz");

                } else {
                    System.out.print("fizz, ");
                }
                position++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {

        while (position <= n) {
            if (position % 5 == 0 && position % 3 != 0) {

                if (position == n) {
                    System.out.print("buzz");

                } else {
                    System.out.print("buzz, ");
                }
                position++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (position <= n) {
            if (position % 3 == 0 && position % 5 == 0) {

                if (position == n) {
                    System.out.print("fizzbuzz");

                } else {
                    System.out.print("fizzbuzz, ");
                }
                position++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (position <= n) {
            if (position % 3 != 0 && position % 5 != 0) {

                if (position == n) {
                    System.out.print(position);

                } else {
                    System.out.print(position + ", ");
                }
                position++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}