package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * <p>
 * Implement the LFUCache class:
 * <p>
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 * When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.
 * For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache.
 * The key with the smallest use counter is the least frequently used key.
 * <p>
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 * // cache=[4,3], cnt(4)=2, cnt(3)=3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * At most 2 * 105 calls will be made to get and put.
 * Implement a Least Frequently Used (LFU) in-memory cache
 * * Cache is limited in size (contains N entries)
 * * Maps an string to a string
 * * On a cache miss, throw exception
 * * For eviction of an item, least frequently used policy is applied.
 *
 * -> used frequency to be considered for the get.
 * -> evict anyone in case of conflict.
 *  -> time complexity -> O(1) for get and set
 *  -> Map -> used to store the entries.
 * "abc" -> 0
 * "xyz" -> 2
 * "ghi" -> 0
 * "tuv" -> 0
 * get(xyz) ->
 * get(xyz) ->
 * 2 -> xyz
 * minF = 0
 * secondMin = 1
 *  -> FrequencyMap ->
 *  rajesh -> 1
 *  pushpendra -> 2
 *  -> reverseFrequencyMap-
 *
 *  freq -> key
 *  Map<String, Map<String, boolean>>
 *  2 -> [pushpendra]
 *  1 -> [rajesh, pushpendra]
 *  0 -> pushpendra ->
 */
public class LFUCache {
    Map<Integer, Integer> map;
    LinkedList<Integer> linkedList;
    Map<Integer, Integer> freqMap;
    Map<Integer, LinkedList<Integer>> reverseFreqMap;
    int capacity;
    int minFreq = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.linkedList = new LinkedList<>();
        this.capacity = capacity;
        this.reverseFreqMap = new HashMap<>();
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value != -1) {
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
            int freq = freqMap.get(key);
            reverseFreqMap.computeIfAbsent(freq, x -> new LinkedList<>()).add(key);
            minFreq = Math.min(minFreq, freq);
        }
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            freqMap.put(key, freqMap.get(key) + 1);
            int freq = freqMap.get(key);
            LinkedList<Integer> orderedElements = reverseFreqMap.getOrDefault(freq, new LinkedList<>());
            orderedElements.remove(key);
            orderedElements.addFirst(key);
            minFreq = Math.min(minFreq, freq);
        } else {
            if (map.size() == capacity) {
                LinkedList<Integer> orderedElements = reverseFreqMap.getOrDefault(minFreq, new LinkedList<>());
                orderedElements.removeLast();
                orderedElements.addFirst(key);
            } else {

            }
            map.put(key, value);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
    }
}

