package com.rflpazini.alticci.app.dataprovider;

import java.util.concurrent.ConcurrentHashMap;

public enum CacheService {
    INSTANCE;

    private final ConcurrentHashMap<Integer, Integer> cache;

    private CacheService() {
        this.cache = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap cache() {
        return this.cache;
    }
}
