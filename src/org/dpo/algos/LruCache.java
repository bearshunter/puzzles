package org.dpo.algos;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final Node<K, V> head = new Node<>(null, null); // dummy head
    private final Node<K, V> tail = new Node<>(null, null); // dummy tail

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    public LruCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity > 0");
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.get(1);
        cache.put(4, "four");

        System.out.println(cache.get(2)); // null (вытеснен)
        System.out.println(cache.get(3)); // three
        System.out.println(cache.get(1)); // one
        System.out.println(cache.get(4)); // four
    }


    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }
        if (map.size() == capacity) {
            Node<K, V> lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node<K, V> fresh = new Node<>(key, value);
        addAfterHead(fresh);
        map.put(key, fresh);
    }

    public V remove(K key) {
        Node<K, V> node = map.remove(key);
        if (node == null) return null;
        remove(node);
        return node.value;
    }

    public int size() {
        return map.size();
    }

    private void moveToFront(Node<K, V> node) {
        remove(node);
        addAfterHead(node);
    }

    private void addAfterHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
    }


}

