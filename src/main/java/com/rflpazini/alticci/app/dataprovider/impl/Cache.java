package com.rflpazini.alticci.app.dataprovider.impl;

import com.rflpazini.alticci.app.dataprovider.CacheService;
import com.rflpazini.alticci.domain.dataprovider.CachePattern;
import jakarta.inject.Singleton;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class Cache implements CachePattern<Integer, Integer> {

    private static final ConcurrentHashMap<Integer, Integer> CACHE = CacheService.INSTANCE.cache();

    @Override
    public Integer get(Object key) {
        return CACHE.get(key);
    }

    @Override
    public void put(final Integer id, final Integer entity) {
        CACHE.put(id, entity);
    }

    @Override
    public boolean contains(Object value) {
        return CACHE.contains(value);
    }

    @Override
    public boolean containsKey(Object key) {
        return this.get(key) != null;
    }
}
