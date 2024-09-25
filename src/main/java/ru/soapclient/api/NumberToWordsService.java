package ru.soapclient.api;

import ru.soapclient.dto.NumberToWordsDto;

import java.math.BigInteger;

public interface NumberToWordsService {
    /**
     * Преобразовать число в слова
     *
     * @param number число
     * @return результат преобразования
     */
    NumberToWordsDto numberToWordsRequest(BigInteger number);
}
