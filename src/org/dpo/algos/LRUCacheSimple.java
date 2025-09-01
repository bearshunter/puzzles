package org.dpo.algos;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheSimple<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCacheSimple(int capacity) {
        // accessOrder = true  → порядок по обращениям (LRU), а не по вставкам
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // при вставке лишнего удаляем самый «старый»
    }

    public static void main(String[] args) {
        LRUCacheSimple<Integer, String> cache = new LRUCacheSimple<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.get(1);
        cache.put(4, "four");

        System.out.println(cache.keySet()); // порядок по «свежести»: [3, 1, 4]
    }
}
