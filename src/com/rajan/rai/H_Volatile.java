package com.rajan.rai;

/***
 * Please note that while volatile is useful for ensuring visibility of changes
 * across threads, it doesn't guarantee atomicity. For atomic operations, you
 * might need to use other synchronization mechanisms like synchronized blocks
 * or the java.util.concurrent package classes
 * 
 * @author raira
 *
 */

public class H_Volatile {
    private boolean flag = false;

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) {
        H_Volatile example = new H_Volatile();

        Thread writerThread = new Thread(() -> {
            System.out.println("Writer thread is updating the flag...");
            example.toggleFlag();
            System.out.println("Flag updated by writer thread.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (!example.isFlag()) {
                System.out.println("Reader thread is waiting...");
            }
            System.out.println("Reader thread detected flag change.");
        });

        writerThread.start();
        readerThread.start();
    }
}
