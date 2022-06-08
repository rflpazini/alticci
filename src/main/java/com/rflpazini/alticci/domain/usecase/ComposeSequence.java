package com.rflpazini.alticci.domain.usecase;

import com.rflpazini.alticci.domain.dataprovider.CachePattern;
import jakarta.inject.Inject;

public class ComposeSequence {

    @Inject
    CachePattern<Integer, Integer> cache;

    public int findSequenceNumber(int number) {
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
        int nthValue = findSequenceNumber(number - 3) + findSequenceNumber(number - 2);
        cache.put(number, nthValue);

        return nthValue;
    }
}
