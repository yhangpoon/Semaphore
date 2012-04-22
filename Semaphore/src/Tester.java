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

    public Tester(Example example, int threadNumber) {
        this.example = example;
        this.threadNumber = threadNumber;
    }

    public void run() {
        example.inc(1);
        example.delay_until_10();
        System.out.println("Thread " + threadNumber + ": " + example.getCounter());
    }
}
