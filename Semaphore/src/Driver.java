/**
 * Driver class to test ReentrantSemaphoreLock and ReentrantLock.
 * 
 * @author Yin
 */
public class Driver {

    /**
     * Main method to start the program.
     * 
     * @param args
     *            standard input arguments
     */
    public static void main(String[] args) {

        // Test on my version
        System.out.println("Testing with My Version of Semaphore Lock");

        ExampleWithSemaphore example = new ExampleWithSemaphore();

        Tester thread1 = new Tester(example, 1);
        Tester thread2 = new Tester(example, 2);
        Tester thread3 = new Tester(example, 3);
        Tester thread4 = new Tester(example, 4);
        Tester thread5 = new Tester(example, 5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Driver: Add 3 ");
            example.inc(3);
            System.out.println("Driver: Counter = " + example.getCounter());
        }

        // Wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        // Test on library version
        System.out.println("\n");
        System.out.println("Testing with Library Version");
        ExampleFromClass example2 = new ExampleFromClass();

        Tester thread6 = new Tester(example2, 6);
        Tester thread7 = new Tester(example2, 7);
        Tester thread8 = new Tester(example2, 8);
        Tester thread9 = new Tester(example2, 9);
        Tester thread10 = new Tester(example2, 10);

        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Driver: Add 3 ");
            example2.inc(3);
            System.out.println("Driver: Counter = " + example2.getCounter());
        }

    }
}
