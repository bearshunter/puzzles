package org.dpo.parallel;

public class Parallel {
     private volatile boolean  flag = false;

    public static void main(String[] args) {
        threadsPriorityExample();
        statesOfThreadExample();
        yieldExample();
    }

    public void changeVolatile(){
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName());
                if(i == 900){
                    flag = true;
                }
            }
        };
    }

    public static void yieldExample() {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.setPriority(Thread.MIN_PRIORITY); // приоритет 1
        t2.setPriority(Thread.MAX_PRIORITY); // приоритет 10

        t1.start();
        t2.start();
    }

    private static void statesOfThreadExample() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000); // TIMED_WAITING
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        System.out.println(t.getState()); // NEW
        t.start();
        System.out.println(t.getState()); // RUNNABLE
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t.getState()); // TERMINATED
    }

    private static void threadsPriorityExample() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    System.out.println("Hello from thread 1");
                }

            }).start();
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    System.out.println("Hello from thread 2");
                }
            }).start();
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    System.out.println("Hello from thread 3");
                }
            }).start();
        }
    }
}
