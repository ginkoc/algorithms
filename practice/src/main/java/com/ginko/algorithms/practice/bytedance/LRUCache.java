package com.ginko.algorithms.practice.bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        MAX_CACHE_SIZE = capacity;
        cache = new LinkedHashMap<Integer, Integer>(MAX_CACHE_SIZE, DEFAULT_LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public int get(int key) {
        Integer res = cache.get(key);
        return res == null ? -1 : res;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
