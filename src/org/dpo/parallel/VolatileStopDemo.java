package org.dpo.parallel;

public class VolatileStopDemo {
    private static class Worker implements Runnable {
        private volatile boolean stop = false;   // гарантирует happens-before на чтение

        public void run() {
            long ops = 0;
            while (!stop) {
                ops++;
            }
            System.out.println("Stopped. ops=" + ops);
        }
        void requestStop() { stop = true; }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();
        Thread t = new Thread(w, "worker");
        t.start();

        Thread.sleep(500);       // даём поработать
        w.requestStop();         // безопасно останавливаем
        t.join();
        System.out.println("Main: done");
    }
}
