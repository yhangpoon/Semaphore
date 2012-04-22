/**
 * This class helps to demonstrate the implementation correctness of the
 * ReentrantSemaphoreLock.
 * 
 * @author Yin
 */
public class Tester extends Thread {

    /**
     * The thread number.
     */
    private int threadNumber;

    /**
     * The Example Test Case.
     */
    private Example example;

    /**
     * Default Constructor.
     * 
     * @param example
     *            -
     * @param threadNumber
     */
    public Tester(Example example, int threadNumber) {
        this.example = example;
        this.threadNumber = threadNumber;
    }

    public void run() {
        System.out.println("Thread " + threadNumber + ": Add 1");
        example.inc(1);
        System.out.println("Thread " + threadNumber + ": Counter = " + example.getCounter());
        example.delay_until_10();
        System.out.println("Thread " + threadNumber + ": Counter = " + example.getCounter());
    }
}
