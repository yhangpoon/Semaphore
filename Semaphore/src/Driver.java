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
        Example example = new Example();

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
    }

}
