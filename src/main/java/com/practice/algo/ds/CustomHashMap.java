package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap<K, V> {
    public static class HMNode<K, V> {
        K key;
        V value;

        public HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    int size;
    LinkedList<HMNode<K, V>>[] buckets;
    double loadFactor = 0.75;

    public CustomHashMap() {
        initialize(4);
        size = 0;
    }

    private void initialize(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bi = hashFn(key);
        int di = getDataFromWithinBucket(key, bi);

        if (di != -1) {
            buckets[bi].get(di).value = value;
        } else {
            HMNode<K, V> newHMNode = new HMNode<>(key, value);
            buckets[bi].add(newHMNode);
            size++;
        }

        if ((double) size / buckets.length > loadFactor) {
            rehash();
        }
    }

    public V remove(K key) {
        int bi = hashFn(key);
        int di = getDataFromWithinBucket(key, bi);

        if (di != -1) {
            HMNode<K, V> hmNode = buckets[bi].get(di);
            buckets[bi].remove(di);
            return hmNode.getValue();
        }
        return null;
    }

    public List<K> keySet() {
        List<K> keyset = new ArrayList<>();
        for (LinkedList<HMNode<K, V>> bucket : buckets) {
            for (HMNode<K, V> hmNode : bucket) {
                keyset.add(hmNode.getKey());
            }
        }
        return keyset;
    }

    private void rehash() {
        LinkedList<HMNode<K, V>>[] oldBuckets = buckets;
        initialize(buckets.length * 2);
        size = 0;
        for (LinkedList<HMNode<K, V>> bucket : oldBuckets) {
            for (HMNode<K, V> hmNode : bucket) {
                put(hmNode.getKey(), hmNode.getValue());
            }
        }
    }

    public V get(K key) {
        int bi = hashFn(key);
        int di = getDataFromWithinBucket(key, bi);

        if (di != -1) {
            return buckets[bi].get(di).getValue();
        }
        return null;
    }

    public boolean containsKey(K key) {
        int bi = hashFn(key);
        int di = getDataFromWithinBucket(key, bi);
        return di != -1;
    }

    private int getDataFromWithinBucket(K key, int bi) {
        int di = 0;
        for (HMNode<K, V> hmNode : buckets[bi]) {
            if (hmNode.getKey() == key) {
                return di;
            }
            di++;
        }
        return -1;
    }

    private int hashFn(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("pushpendra", 7);
        map.put("ruchi", 8);
        map.put("avi", 9);
        map.put("test", 10);
        map.remove("ruchi");

        System.out.println(map.keySet());
    }
}
