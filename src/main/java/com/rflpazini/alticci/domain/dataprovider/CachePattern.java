package com.rflpazini.alticci.domain.dataprovider;

public interface CachePattern<K, V> {

    void put(K id, V entity);

    V get(Object key);

    boolean contains(Object value);

    boolean containsKey(Object value);

}
