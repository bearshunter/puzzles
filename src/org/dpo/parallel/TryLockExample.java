package org.dpo.parallel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void doWork() {
        if (lock.tryLock()) { // сразу проверяем
            try {
                System.out.println(Thread.currentThread().getName() + " получил доступ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " не получил доступ, пропускаю");
        }
    }

    public void doWorkWithTimeout() {
        try {
            if (lock.tryLock(500, TimeUnit.MILLISECONDS)) { // ждём 500 мс
                try {
                    System.out.println(Thread.currentThread().getName() + " получил доступ");
                    Thread.sleep(1000);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " устал ждать и ушёл");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
