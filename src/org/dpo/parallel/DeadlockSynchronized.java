package org.dpo.parallel;

public class DeadlockSynchronized {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK_A) {
                sleep(100);                 // даём шанс второму потоку захватить B
                synchronized (LOCK_B) {     // ждём B, который уже у t2 → deadlock
                    System.out.println("t1 done");
                }
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            synchronized (LOCK_B) {
                sleep(100);
                synchronized (LOCK_A) {     // ждём A, который уже у t1 → deadlock
                    System.out.println("t2 done");
                }
            }
        }, "T2");

        t1.start();
        t2.start();
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}

