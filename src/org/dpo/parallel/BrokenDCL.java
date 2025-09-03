package org.dpo.parallel;

import java.util.HashMap;
import java.util.Map;

public class BrokenDCL {
    static class LazyCache {
        // ОШИБКА: нет volatile → публикация небезопасна
        private static LazyCache instance;
        private final Map<String, String> cache;

        private LazyCache() {
            // эмуляция тяжелой инициализации
            cache = new HashMap<>();
            cache.put("hello", "world");
        }

        public static LazyCache getInstance() {
            if (instance == null) {                  // 1-я проверка
                synchronized (LazyCache.class) {
                    if (instance == null) {          // 2-я проверка
                        instance = new LazyCache();  // публикация без volatile!
                    }
                }
            }
            return instance;
        }

        public int size() { return cache.size(); }   // может кинуть NPE при «частичной» публикации
    }

    public static void main(String[] args) {
        // Попытаемся спровоцировать проблему нагрузкой
        Runnable r = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                LazyCache c = LazyCache.getInstance();
                // В редких случаях при гонках возможен NPE из-за cache == null
                try {
                    c.size();
                } catch (NullPointerException e) {
                    System.out.println("Поймали NPE: частично сконструированный объект.");
                    System.exit(0);
                }
            }
        };
        new Thread(r, "t1").start();
        new Thread(r, "t2").start();
        new Thread(r, "t3").start();
    }
}

