package com.rflpazini.alticci.domain.usecase;

import com.rflpazini.alticci.domain.dataprovider.CachePattern;
import jakarta.inject.Inject;

public class FIndSequenceNumberUseCase implements FindSequenceNumber {

    @Inject
    CachePattern<Integer, Integer> cache;

    public int search(final int number) {
        // check if number exist in cache
        if (cache.containsKey(number)) {
            return cache.get(number);
        }

        // validate if is 0, 1 or 2
        // and return the expected
        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }

        // recursive call the function applying the formula
        // until find our number
        int nthValue = search(number - 3) + search(number - 2);
        cache.put(number, nthValue);

        return nthValue;
    }

    public int searchBest(final int number) {
        initCacheObject();

        for (int i = 3; i < number; i++) {
            var nthValue = search(number - 3) + search(number - 2);
            cache.put(number, nthValue);
        }

        return cache.get(number);
    }

    private void initCacheObject() {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 1);
    }
}
